package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void example0()  {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete("Got it OK");

        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException e ) {

        } catch (ExecutionException e ) {

        }
    }


    public static void exampleCompletableFuture() throws Exception  {
        java.util.concurrent.CompletableFuture<String> helloFuture
                = java.util.concurrent.CompletableFuture.supplyAsync(() -> "Hello");
        java.util.concurrent.CompletableFuture<String> greetingFuture
                = java.util.concurrent.CompletableFuture.supplyAsync(() -> "World");

        java.util.concurrent.CompletableFuture<String> combinedFuture
                = helloFuture.thenCombine(
                greetingFuture, (m1, m2) -> m1 + " " + m2);

        System.out.println(combinedFuture.get());
    }
}
