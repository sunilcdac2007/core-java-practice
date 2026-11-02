package com.interview.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.util.concurrent.locks.ReentrantReadWriteLock.*;

public class PrintInSequence {


    private volatile int number=0;

    boolean isIncrement = true;
    boolean isPrint=true;

    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    Lock lock = rwLock.writeLock();

    public void increment(){

        lock.lock();
        if ( !isPrint && isIncrement){
            number = number+1;
            if(number == 5) {
                isIncrement = false;
            }
            isPrint=true;
        }
        lock.unlock();
    }

    public void decrement(){
        lock.lock();
        if( !isIncrement && !isPrint){
            number = number-1;
            if(number==0) {
                isIncrement = true;
            }
            isPrint=true;
        }
        lock.unlock();
    }

    public void print(){
        if(isPrint){
            System.out.println(number);
            isPrint= !isPrint;
        }
    }

    static void main() {
    PrintInSequence sequence = new PrintInSequence();
        Thread t1 = new Thread(()->{
            while(true) {
                sequence.increment();
            }
        });

        Thread t2 = new Thread(()->{
            while(true) {
                sequence.decrement();
            }
        });
        Thread t3 = new Thread(()->{
            while(true) {
                sequence.print();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }



}
