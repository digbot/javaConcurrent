package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class RaceCondition {
    private static int count = 0;

    static void increment() {
        count += 1;
    }

    public static void exampleOfRaceCondition() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        IntStream.range(0, 1000)
                .forEach(
                        i -> executor.submit(
                                RaceCondition::increment
                        )
                );
        Thread.sleep(10_000);
        System.out.println(count);
    }
}
