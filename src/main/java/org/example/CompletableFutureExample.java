package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
    public static void exampleSupplyThenApply0()  {
        try {
            CompletableFuture
                .supplyAsync(() -> Thread.currentThread().getName() + " 1| ")
                .thenApply(supplyResult ->  supplyResult + Thread.currentThread().getName() + " 2| " )
                .thenAccept(
                        thenApplyResult -> System.out.println(thenApplyResult +  Thread.currentThread().getName() + " 3| " )

                )
                .get();

        } catch (InterruptedException e ) {

        } catch (ExecutionException e ) {
        }
    }

    public static void exampleSupplyThenApply1()  {
        try {
            CompletableFuture
                .supplyAsync(() -> { return "Like and ";})
                .thenApply(supplyResult -> supplyResult + "Subscribe")
                .thenAccept(thenApplyResult -> System.out.println(thenApplyResult + "!!!!"))
                .get();

        } catch (InterruptedException e ) {

        } catch (ExecutionException e ) {

        }

    }

    public static void exampleSupplyAsync()  {
        System.out.println("Main Thread: " + Thread.currentThread().getName());

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {

            }

            return "Future Thread [Wait 5 second]: " + Thread.currentThread().getName();
        });

        try {
            System.out.println("Supply Result: " + completableFuture.get());
        } catch (InterruptedException e ) {

        } catch (ExecutionException e ) {

        }
    }

    public static void exampleRunAsync()  {
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
            }
            System.out.println(" Future Thread [Wait 5 second]: " + Thread.currentThread().getName());
        });
        try {
            completableFuture.get();
        } catch (InterruptedException e ) {

        } catch (ExecutionException e ) {

        }
    }

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
