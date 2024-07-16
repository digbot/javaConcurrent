package org.example;

import java.util.concurrent.*;

public class CallableExample {
    public static void example1() {
        Callable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return "Returing after sleeping for 2 seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(task);
        System.out.println("Is done? " + future.isDone());
        String result = null;
        try {
            result = future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // Handle the InterruptedException
            e.printStackTrace(); // or log the exception
        } catch (ExecutionException e) {
            // Handle the ExecutionException
            e.printStackTrace(); // or log the exception
        } catch (TimeoutException e) {
        // Handle the TimeoutException
        e.printStackTrace();
        }
        System.out.println("Is done? " + future.isDone());
        System.out.println(result);
    }
}
