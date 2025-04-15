import java.util.ArrayList;
public class Sum {
    public static void main(String[] args) {
        int x = 10;
        int y = 950;
        int sum = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        // Find numbers divisible by 6 and 9
        for (int i = x; i <= y; i++) {
            if (i % 6 == 0 && i % 9 == 0) {
                arr.add(i); // Add i to our array
            }
        }
        // Sum of all the elements in the array
        for (int num : arr) {
            sum += num;
        }
        // Print the result
        System.out.println("Sum of all numbers divisible by 6 and 9 from " + x + " to " + y + " is: " + sum);
    }
}