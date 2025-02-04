
import java.util.Arrays;
// Using mrthods learnt from Arrays class
public class $array {
    public static void main(String[] args) 
     {
      int array[] = {7, 2, 8, 10, 3};
      Arrays.sort(array);
     int index = Arrays.binarySearch(array, 8);
      System.out.println(Arrays.toString(array));
      System.out.println("Index of target 8 : " + index);
     }
  }