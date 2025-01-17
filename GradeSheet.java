import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeSheet {

    static class Student {
        String name;
        Integer maths;
        Integer dbms;
        Integer os;
        Integer daa;
        Integer aiml;
        float percentage;

        Student(String name, Integer maths, Integer dbms, Integer os, Integer daa, Integer aiml) {
            this.name = name;
            this.maths = maths;
            this.dbms = dbms;
            this.os = os;
            this.daa = daa;
            this.aiml = aiml;
            this.percentage = (maths + dbms + os + daa + aiml) / 5.0f; 
    }

    public static void main(String[] args) {
            try (Scanner input = new Scanner(System.in)) {
                List<Student> students = new ArrayList<>();
                // Input loop for multiple students
                while (true) {
                    System.out.print("Enter student name (or type 'exit' to finish): ");
                    String name = input.nextLine();
                    if (name.equalsIgnoreCase("exit")) {
                        break;
                    }
                    
                    System.out.print("Enter grade for Maths: ");
                    Integer maths = input.nextInt();
                    System.out.print("Enter grade for DataBase Management Systems: ");
                    Integer dbms = input.nextInt();
                    System.out.print("Enter grade for Operating Systems: ");
                    Integer os = input.nextInt();
                    System.out.print("Enter grade for Design and Analysis of Algorithms: ");
                    Integer daa = input.nextInt();
                    System.out.print("Enter grade for AIML: ");
                    Integer aiml = input.nextInt();
                    input.nextLine();
                    students.add(new Student(name, maths, dbms, os, daa, aiml));} 
                System.out.println("\nGrade Sheet Sem 3\n");
                System.out.printf("%-40s %-10s%n", "Student Name", "Grades");
                System.out.println("----------------------------------------------------------------------------------");
                for (Student student : students) {
                    System.out.printf("%-40s %-10s%n", student.name, "");
                    System.out.printf("%-40s %-10d%n", "MATHS", student.maths);
                    System.out.printf("%-40s %-10d%n", "DataBase Management Systems", student.dbms);
                    System.out.printf("%-40s %-10d%n", "Operating Systems", student.os);
                    System.out.printf("%-40s %-10d%n", "Design and Analysis of Algorithms", student.daa);
                    System.out.printf("%-40s %-10d%n", "AIML", student.aiml);
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.printf("%-40s %-10.2f%n", "Percentage", student.percentage);
                    System.out.println("----------------------------------------------------------------------------------");
                }
                // Close the scanner
            }
    }
 }
}