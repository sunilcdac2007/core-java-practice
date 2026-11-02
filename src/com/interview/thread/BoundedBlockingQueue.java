package com.interview.thread;

import com.sun.security.jgss.GSSUtil;

import javax.print.attribute.standard.JobKOctets;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {

    Object[] items;
    int size;
    int currentSize;
    int takeIndex;
    int putIndex;
    Lock lock;
    Condition notNull;
    Condition notFull;


    BoundedBlockingQueue(int n){
        items = new Object[n];
        this.size=n;
        this.currentSize=0;
        this.takeIndex= this.putIndex=0;
        this.lock = new ReentrantLock();
        this.notNull= lock.newCondition();
       this.notFull = lock.newCondition();
    }

    public Object pool(long timeout, TimeUnit timeUnit) throws InterruptedException {

        if(currentSize == 0){
            return null;
        }
        long remainingTime = timeUnit.toNanos(timeout);

        lock.lockInterruptibly();
        try{

            while(currentSize == 0){

                if(remainingTime <=0){
                    return null;
                }
                System.out.println("POOL remainingTime "+ remainingTime);
                remainingTime = notNull.awaitNanos(remainingTime);
            }

            Object it = dequeue();
            notNull.signal();
            return it;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    public Object dequeue(){
        System.out.println(" dequeeu "+ Thread.currentThread().getName()+"  "+ currentSize);
          Object it = items[takeIndex];
          items[takeIndex]=null;
          if(++takeIndex == items.length){
              takeIndex=0;
          }
          currentSize--;
          return it;
    }

    public boolean offer(Object item, long timeout, TimeUnit timeUnit) throws InterruptedException {

        if(item == null){
            throw  new IllegalArgumentException();
        }

        long remainsTime = timeUnit.toNanos(timeout);
        lock.lockInterruptibly();
        try{
            while(currentSize == items.length){
                if(remainsTime <=0){
                    return false;
                }
                remainsTime = notFull.awaitNanos(remainsTime);

            }
            enqueue(item);
            notFull.signal();

        }finally {
            lock.unlock();
        }

        return true;
    }

    public void enqueue(Object item){
        System.out.println("enqueue "+ Thread.currentThread().getName()+" "+currentSize);
        items[putIndex] = item;
        if(++putIndex == items.length){
            putIndex=0;
        }
        currentSize++;
    }

    static void main() throws InterruptedException {


        ExecutorService offerExecutor = Executors.newFixedThreadPool(10);

        BoundedBlockingQueue boundedBlockingQueue = new BoundedBlockingQueue(4);
        for(int i=0; i<20; i++){
            System.out.println("added in exector");
            Object obj = new Object();
            offerExecutor.execute( ()-> {
                try {
                    while(true){
                    if(boundedBlockingQueue.offer(obj, 1, TimeUnit.MILLISECONDS)){
                        break;
                    }
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        ExecutorService poolExecutor = Executors.newFixedThreadPool(10);
        for(int i=0; i<20; i++){
            System.out.println("remove in exector");
            offerExecutor.execute( ()-> {
                try {
                    boundedBlockingQueue.pool( 1, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }


    }


}
