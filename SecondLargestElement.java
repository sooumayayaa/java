public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 15};
        int secondLargest = findSecondLargest(arr);
        System.out.println("The second largest element is: " + secondLargest);
    }
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array should have at least two elements.");
            return -1;
        }
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest && num != firstLargest) {
                secondLargest = num;
            }
        }
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element found.");
            return -1;
        }
        return secondLargest;
    }
}