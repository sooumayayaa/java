import java.util.ArrayList;

public class Sum {

        /**
         * @param args
         */
        public static void main(String[] args)
{
    int x = 10;
    int y = 950;
    int i;
    int sum = 0;

    ArrayList<Integer> arr = new ArrayList<>();
    for (i = x; i <= y;  i++)
    {
       if (i % 6 == 0 && i % 9 == 0)
       {
           arr.add(i); // add i to our array
       }
  
    // sum of all the elemnets of the new array
    for(int num) 
    {
        num+=sum;
     }
}
     
System.out.println("Sum of all numbers divisible by 6 and 9 from "+ x +" to " + y + " is: " + sum);

}
}