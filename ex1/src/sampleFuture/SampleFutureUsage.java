package sampleFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SampleFutureUsage {

    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to the executor
        Future<Void> future1 = executor.submit(createTask(2, "Message from method 1"));
        Future<Void> future2 = executor.submit(createTask(2, "Message from method 2"));
        Future<Void> future3 = executor.submit(createTask(2, "Message from method 3"));

        // Wait for all futures to complete
        try {
            future1.get();
            future2.get();
            future3.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shut down the executor
            executor.shutdown();
        }
    }

    private static Callable<Void> createTask(int delayInSeconds, String message) {
        return () -> {
            try {
                TimeUnit.SECONDS.sleep(delayInSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(message);
            return null;
        };
    }
}

