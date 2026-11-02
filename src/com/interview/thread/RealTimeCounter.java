package com.interview.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class RealTimeCounter {
    int size = 300;
    AtomicIntegerArray counter = new AtomicIntegerArray(size);
   // volatile  int pos=0;
    private final AtomicInteger pos = new AtomicInteger();
    private static RealTimeCounter INSTANCE;

    RealTimeCounter(){
        PositionUpdater positionUpdater = new PositionUpdater(this);
        positionUpdater.start();
    }

    static void main() {

        RealTimeCounter realTimeCounter = RealTimeCounter.getInstance();
        int TOTAL_EVENT = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(TOTAL_EVENT);

        for(int i=0; i< TOTAL_EVENT; i++){
            executorService.execute(()->{
                realTimeCounter.addEvent();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        System.out.println(realTimeCounter.getTotalEvent());


    }

    public static RealTimeCounter getInstance(){
        if(INSTANCE == null){
            synchronized (RealTimeCounter.class){
                if(INSTANCE == null){
                    INSTANCE = new RealTimeCounter();
                }
            }
        }
        return INSTANCE;
    }
    public void addEvent(){
        counter.getAndIncrement(pos.get());
    }

    public void incrementPosition(){
        counter.set((pos.get()+1)%size, 0);
        pos.getAndIncrement();
    }

    public int getTotalEvent(){
        int total =0;
        for(int i=0; i < size; i++){
            total = total + counter.get(i);
        }
        return total;
    }

    class PositionUpdater extends TimerTask {

        private final RealTimeCounter realTimeCounter;
        private final Timer timer = new Timer(true);
        private static final int DELAY= 1000;

        PositionUpdater(RealTimeCounter realTimeCounter){
            this.realTimeCounter = realTimeCounter;
        }

        public void start(){
            timer.schedule(this,DELAY);
        }
        @Override
        public void run() {
            realTimeCounter.incrementPosition();
        }
    }
}
