package com.interview.thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CountingWord {

    ConcurrentHashMap<String, AtomicInteger> mapCount = new ConcurrentHashMap<>();


    public void addWord(String word){

        AtomicInteger count = mapCount.get(word);
        if(count == null){
         count = new AtomicInteger(1);
         count = mapCount.putIfAbsent(word, count);
        } else{
            count.getAndIncrement();
        }

    }

    public Integer getWordCount(String word){
       AtomicInteger count = mapCount.get(word);
        if(count!= null) {
            return count.get();
        }
        return 0;
    }

    static void main() throws InterruptedException {
        ExecutorService addExecutor = Executors.newFixedThreadPool(3);
        CountingWord countingWord = new CountingWord();

        CountDownLatch countDownLatch = new CountDownLatch(30);
        for(int i=0; i< 10; i++){
             final int i1=i;
            addExecutor.execute(()-> countingWord.addWord("test"+i1));
            countDownLatch.countDown();
        }

        for(int i=0; i< 10; i++){
            final int i1=i;
            addExecutor.execute(()-> countingWord.addWord("test"+i1));
            countDownLatch.countDown();
        }

        for(int i=0; i< 10; i++){
            final int i1=i;
            addExecutor.execute(()-> countingWord.addWord("test"+i1));
            countDownLatch.countDown();
        }
        ExecutorService readExecutor = Executors.newFixedThreadPool(3);
        countDownLatch.await();
        readExecutor.shutdown();
        addExecutor.shutdown();

        for(int i=0; i< 10; i++){
            System.out.println(" reading value "+countingWord.getWordCount("test"+i));
        }

    }



}
