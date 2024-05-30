package math;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SumExample {

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

        // Calculate the sums using CompletableFuture
        CompletableFuture<Integer> sum1 = CompletableFuture.supplyAsync(() -> num1 + num2);
        CompletableFuture<Integer> sum2 = CompletableFuture.supplyAsync(() -> num3 + num4);

        // Calculate the final sum by combining the intermediate sums
        CompletableFuture<Integer> finalSum = sum1.thenCombine(sum2, Integer::sum);

        // Display the result
        try {
            System.out.println("The final result is: " + finalSum.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        scanner.close();
    }
}

