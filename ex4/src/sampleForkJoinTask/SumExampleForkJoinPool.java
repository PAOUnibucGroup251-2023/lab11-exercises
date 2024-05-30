package sampleForkJoinTask;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumExampleForkJoinPool {

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

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create and invoke the tasks
        SumTask sum1Task = new SumTask(num1, num2);
        SumTask sum2Task = new SumTask(num3, num4);
        int sum1 = pool.invoke(sum1Task);
        int sum2 = pool.invoke(sum2Task);

        // Final sum task
        SumTask finalSumTask = new SumTask(sum1, sum2);
        int finalSum = pool.invoke(finalSumTask);

        // Display the result
        System.out.println("The final result is: " + finalSum);

        scanner.close();
        pool.shutdown();
    }

    // RecursiveTask for calculating sum of two integers
    static class SumTask extends RecursiveTask<Integer> {
        private final int a;
        private final int b;

        public SumTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        protected Integer compute() {
            return a + b;
        }
    }
}
