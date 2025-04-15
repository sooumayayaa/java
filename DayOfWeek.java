import java.util.Scanner;
public class DayOfWeek {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter a number (1-7): ");
            int day = input.nextInt();
            
            switch (day) {
                case 1 -> System.out.println("Sunday");
                case 2 -> System.out.println("Monday");
                case 3 -> System.out.println("Tuesday");
                case 4 -> System.out.println("Wednesday");
                case 5 -> System.out.println("Thursday");
                case 6 -> System.out.println("Friday");
                case 7 -> System.out.println("Saturday");
                default -> System.out.println("Invalid input! Please enter a number between 1 and 7.");
}
        }
}}

        