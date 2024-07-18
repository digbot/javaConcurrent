package org.example;

import java.util.concurrent.*;

public class FutureExample {

    public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public static Future<String> createDummyFuture() throws InterruptedException {
       Future<String> stringFuture = cachedThreadPool.submit( ()-> {
           System.out.println("Submitted  thread:: " +  Thread.currentThread().getName());
            Thread.sleep(3000);
            return "Process Completed";
       });

       return stringFuture;
    }
/*
    public static CompletableFuture<String> createDummyCompletableFuture() throws InterruptedException {
       // CompletableFuture<String> stringFuture = new CompletableFuture<>().completeAsync(() -> {

         //   return "CompletableFuture Done";
       /// });

        return stringFuture;
    }*/
}
