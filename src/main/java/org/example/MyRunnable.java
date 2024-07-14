package org.example;

public class MyRunnable implements Runnable {

    private int var;

    public MyRunnable(int var) {
        this.var = var;
    }

    public void run() {
        // code in the other thread, can reference "var" variable
        System.out.println("Hello from a MyRunnable->run");
    }

}