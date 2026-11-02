package com.interview.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolImpl2 {

    static void main() throws InterruptedException {
        // Initialize pool with 3 active worker threads
        ThreadPoolImpl2 pool = new ThreadPoolImpl2(3);

        // Submit 10 tasks to the pool
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing Task " + taskId);
                try {
                    Thread.sleep(500); // Simulate processing time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Allow some time for tasks to progress before initiating shutdown
        Thread.sleep(2000);
        System.out.println("Initiating pool shutdown...");
        pool.shutdown();
    }
    BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    List<WorkerThread> workers ;
    volatile  boolean isShutdown ;

    ThreadPoolImpl2(int size){
         workers = new ArrayList<>(size);
         for(int i=0; i < size; i++){

             WorkerThread worker = new WorkerThread("thread "+i);
             workers.add(worker);
             worker.start();
         }



    }

    public void submit(Runnable task){
              synchronized (this){
                  if(!isShutdown) {
                      taskQueue.add(task);
                  }
              }
    }

    public void shutdown(){

        synchronized (this){
            this.isShutdown = true;
            for(WorkerThread worker: workers){
                worker.interrupt();
            }
        }
    }


    class WorkerThread extends  Thread{

        String name;
        public WorkerThread(String name){
            this.name = name;
        }

        @Override
        public void run(){

            while(!isShutdown || !taskQueue.isEmpty()){
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        }



    }

}
