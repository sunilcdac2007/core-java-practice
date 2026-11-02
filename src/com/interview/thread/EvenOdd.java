package com.interview.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EvenOdd {

    private volatile int number =0;

    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    Lock lock = rwLock.writeLock();

    public void odd() {

        lock.lock();
        if(number % 2 != 0 && number < 10){
            System.out.println(number);
            number= number+1;
        }
        if(number>=10){
            System.out.println("current thread interupted ");
            Thread.currentThread().interrupt();

        }
        lock.unlock();
    }


    public void even(){
        lock.lock();
        if(number % 2 == 0 && number<10){
            System.out.println(number);
            number= number+1;
        }
        if(number>=10){
            System.out.println("current thread interupted ");
            Thread.currentThread().interrupt();
        }
        lock.unlock();
    }

    static void main() {
        EvenOdd evenOdd = new EvenOdd();
        Thread t1 = new Thread(()->{

            while(true){
                evenOdd.odd();

            }
        });

        Thread t2 = new Thread(()->{

            while(true){
                evenOdd.even();

            }
        });

        t1.start();
        t2.start();
        // Stop the thread
        t1.interrupt();
        // Stop the thread
        t2.interrupt();
    }
}
