import java.util.Scanner;

public class DigitSum {
    public static void main(String[] args) {
        // Prompt user for input
        try (Scanner input_int = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter an integer: ");
            int num = input_int.nextInt();
            
            int sum = 0;
            
            // Calculate sum of digits using while loop
            while (num > 0) {
                int digit = num % 10; // Extract last digit and add to sum
                sum += digit;
                num = (num - digit)/10; // Remove last digit
            }
            
            // Display the result
            System.out.println("Sum of the digits: " + sum);
        }
    }
}
