

import java.util.Scanner;

public class personal_info {
    public static void main(String[] args){
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter your Full Name :");
            String name = input.nextLine();
            System.out.println("Enter your address :");
            String address = input.nextLine();
            
            System.out.println("User Information");
            System.out.println("Name : " + name);
            System.out.println("Address : " + address);
        }
    }
}
