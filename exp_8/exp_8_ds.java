import java.io.*;
import java.util.Scanner;

class StudentDataWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (FileWriter writer = new FileWriter("student.txt", true);
             BufferedWriter bw = new BufferedWriter(writer)) {

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter roll number: ");
            int rollNumber = scanner.nextInt();

            scanner.nextLine(); // Consume newline

            System.out.print("Enter grade: ");
            String grade = scanner.nextLine();

            bw.write("Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade);
            bw.newLine();

            System.out.println("Student data written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        } finally {
            scanner.close();
        }
    }
}
