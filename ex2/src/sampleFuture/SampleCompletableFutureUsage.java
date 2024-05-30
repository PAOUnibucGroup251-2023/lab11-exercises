package sampleFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SampleCompletableFutureUsage {

    public static void main(String[] args) {
        // Call the methods in order
        CompletableFuture<Void> future1 = waitAndPrintMessage1();
        CompletableFuture<Void> future2 = waitAndPrintMessage2();
        CompletableFuture<Void> future3 = waitAndPrintMessage3();

        // Wait for all futures to complete
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
        
        // Ensure all futures complete before exiting the main method
        try {
            allFutures.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<Void> waitAndPrintMessage1() {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2); // Wait for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Message from method 1");
        });
    }

    public static CompletableFuture<Void> waitAndPrintMessage2() {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2); // Wait for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Message from method 2");
        });
    }

    public static CompletableFuture<Void> waitAndPrintMessage3() {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2); // Wait for 3 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Message from method 3");
        });
    }
}
