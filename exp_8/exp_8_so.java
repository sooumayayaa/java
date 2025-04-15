import java.io.*;

class StudentDataReader {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("student.txt");
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
