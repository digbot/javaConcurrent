package org.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void DelayExample() {
        System.out.println("Starting one-minute countdown now...");
        ScheduledFuture<?> countdown = scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                // do the thing
                System.out.println("Out of time!");
            }}, 1, TimeUnit.MINUTES);

            while (!countdown.isDone()) {
                try {
                    Thread.sleep(1000);
                    System.out.println("do other stuff here");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            scheduler.shutdown( );
    }
}
