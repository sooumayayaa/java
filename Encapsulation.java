
public class Encapsulation {
    public static void main(String[] args) {
        // Create an instance of the Student class
        Student student = new Student();

        // Using setter methods to set values
        student.setName("Soumya");
        student.setAge(20);

        // Using getter methods to get values
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
    }
}

class Student {
    // Private fields
    private String name;
    private int age;

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        if (age > 18) { // Validation logic
            this.age = age;
        } else {
            System.out.println("Age must be positive.");
            this.age = age;
        }
    }
}
