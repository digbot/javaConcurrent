package org.example;

import java.util.concurrent.*;

public class FutureExample {


    static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public static Future<String> createDummyFuture() throws InterruptedException {
       Future<String> stringFuture = cachedThreadPool.submit( ()-> {
                Thread.sleep(3000);
                return "Process Complated";
        });

       return stringFuture;
    }

}
