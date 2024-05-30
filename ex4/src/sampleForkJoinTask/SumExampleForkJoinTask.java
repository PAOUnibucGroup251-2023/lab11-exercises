package sampleForkJoinTask;


import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ForkJoinPool;

public class SumExampleForkJoinTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read 4 numbers from the keyboard
        System.out.println("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = scanner.nextInt();
        System.out.println("Enter the third number: ");
        int num3 = scanner.nextInt();
        System.out.println("Enter the fourth number: ");
        int num4 = scanner.nextInt();

        // Create tasks using ForkJoinTask.adapt
        ForkJoinTask<Integer> sum1Task = ForkJoinTask.adapt(() -> num1 + num2);
        ForkJoinTask<Integer> sum2Task = ForkJoinTask.adapt(() -> num3 + num4);

        // Execute tasks using the common pool
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        commonPool.execute(sum1Task);
        commonPool.execute(sum2Task);

        try {
            int sum1 = sum1Task.get();
            int sum2 = sum2Task.get();

            // Create and execute the final sum task
            ForkJoinTask<Integer> finalSumTask = ForkJoinTask.adapt(() -> sum1 + sum2);
            commonPool.execute(finalSumTask);
            int finalSum = finalSumTask.get();

            // Display the result
            System.out.println("The final result is: " + finalSum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
