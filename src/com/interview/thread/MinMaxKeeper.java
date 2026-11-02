package com.interview.thread;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MinMaxKeeper {


    AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
    AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);

    public void updateMinMax(int number){
        // update min value
        while(true){

            int minvalue = min.get();
            System.out.println("xxx "+minvalue + "  "+ number);
            if(number > minvalue){
                break;
            } else if(min.compareAndSet(minvalue,number)){
                break;
            }

        }

        // update max value

        while(true){
            int maxValue = max.get();
            System.out.println("mxax "+maxValue + "  "+ number);

            if(number < maxValue){
                break;
            } else if ( max.compareAndSet(maxValue,number)){
                break;
            }

        }

    }

    public int getMinValue(){
        return min.get();
    }

    public int getMaxValue(){
        return max.get();
    }

    static void main() throws InterruptedException {

        MinMaxKeeper minMaxKeeper = new MinMaxKeeper();
        ExecutorService updater = Executors.newFixedThreadPool(3);
        for(int i=0; i< 20; i++){
            updater.execute(()->
                minMaxKeeper.updateMinMax((int) Math.round(Math.random())));

        }

        updater.shutdown();
        updater.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(minMaxKeeper.getMaxValue());
        System.out.println(minMaxKeeper.getMinValue());



    }
}
