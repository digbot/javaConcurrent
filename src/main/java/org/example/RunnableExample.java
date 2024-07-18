package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CompletableFuture;

/*
    Futures cannot be completed manually
    Action cannot be performed unit the result is available
    Attaching a callback function is not possible
    Multiple Futures cannot be chained  together
    Multiple Futures cannot be combined together
    There is no exepetion handleing in the Future API

 */
public class RunnableExample {

    public static void example0()  {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {

                System.out.println("Hello from a thread");
            }
        };

        r1.run();
    }

    public static void exampleNewSingleThreadExecutor()  {
        Executors.newSingleThreadExecutor().submit(() -> {
            // yourCode
            System.out.println("Hello from a thread");
        });
    }

    public static void exampleRunnable1()  {
        //MyRunnable myRunnable = new MyRunnable(0);
        //Thread t = new Thread(myRunnable);
        //t.start();
    }

    public static void example1() {

        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Executing:" + name);
        };

        Thread thread1 = new Thread(task);
        thread1.start();
        Thread thread2 = new Thread(task);
        thread2.start();
    }

    public static void example2() {
        //ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(() -> {
            String name = Thread.currentThread().getName();
            System.out.println("Executing:" + name);
        });
        try {
            boolean terminated = executor.awaitTermination(10, TimeUnit.SECONDS);
            if (!terminated) {
                executor.shutdown();
                System.out.println("Shutdown Finished");
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException with msg" + e.getMessage());
        }
    }
}
