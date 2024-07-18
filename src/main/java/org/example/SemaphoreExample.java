package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Semaphore semaphore = new Semaphore(3);
        semaphore.acquire(4);
        semaphore.acquire();
        semaphore.release();
        System.out.println(semaphore.availablePermits());
    }
}
