import java.util.ArrayList;
import java.util.Scanner;
public class fibo {
    public static void main(String[] args) {
        // The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones.
        try (Scanner input = new Scanner(System.in)) {
            // The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones.
            System.out.print("Enter the number of terms for the Fibonacci series: ");
            int n = input.nextInt();
            ArrayList<Integer> fibonacci = new ArrayList<>();
            
            // Handle the first two numbers separately
            if (n > 0) fibonacci.add(0);
            if (n > 1) fibonacci.add(1);
            
            // Generate the Fibonacci series and store in the list
            for (int i = 2; i < n; i++) {
                int nextTerm = fibonacci.get(i - 1) + fibonacci.get(i - 2);
                fibonacci.add(nextTerm);
            }
            // Print Fibonacci series until second-last index
            System.out.print("Fibonacci Series until index ");
            System.out.print(fibonacci + " ");
        }
    }
}

