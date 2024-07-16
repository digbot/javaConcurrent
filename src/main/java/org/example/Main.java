package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
    this is a hot fix  code
*/
public class Main {
    public static void main(String[] args) throws InterruptedException,ExecutionException {
        System.out.println(System.currentTimeMillis());
        Future<String> dummmyFuture = FutureExample.createDummyFuture();
        Thread.sleep(4000);
        System.out.println(dummmyFuture.get());
        System.out.println(System.currentTimeMillis());
        FutureExample.cachedThreadPool.shutdown();
    }
}