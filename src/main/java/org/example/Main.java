package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
    this is a hot fix  code
*/
public class Main {
    public static void main(String[] args) throws InterruptedException,ExecutionException {


        MyRunnableExample.main(args);

        /*
        System.out.println("Running  thread:: " +  Thread.currentThread().getName());

        System.out.println(System.currentTimeMillis());
        Future<String> dummmyFuture = FutureExample.createDummyFuture();
        //Thread.sleep(4000);

        while(!dummmyFuture.isDone()) {
            Thread.sleep(500);
            System.out.println("Still in process:: " +  System.currentTimeMillis() );
        }

        System.out.println(dummmyFuture.get() + " :: " + System.currentTimeMillis());
        FutureExample.cachedThreadPool.shutdown();
        System.out.println("cachedThreadPool shutdown!!!");*/
    }
}