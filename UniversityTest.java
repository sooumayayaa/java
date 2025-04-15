

// Base class
class Person {
    protected String name;
    protected int age;
    protected String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age + ", Address: " + address);
    }
}

// Staff class extending Person
class Staff extends Person {
    protected int staffId;
    protected String department;

    public Staff(String name, int age, String address, int staffId, String department) {
        super(name, age, address);
        this.staffId = staffId;
        this.department = department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Staff ID: " + staffId + ", Department: " + department);
    }
}

// Professor class extending Staff
class Professor extends Staff {
    private String specialization;

    public Professor(String name, int age, String address, int staffId, String department, String specialization) {
        super(name, age, address, staffId, department);
        this.specialization = specialization;
    }

    public void conductLecture() {
        System.out.println(name + " is conducting a lecture on " + specialization);
    }
}

// Student class extending Person
class Student extends Person {
    protected int studentId;
    protected String course;

    public Student(String name, int age, String address, int studentId, String course) {
        super(name, age, address);
        this.studentId = studentId;
        this.course = course;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Student ID: " + studentId + ", Course: " + course);
    }
}

// GraduateStudent class extending Student
class GraduateStudent extends Student {
    private String researchTopic;

    public GraduateStudent(String name, int age, String address, int studentId, String course, String researchTopic) {
        super(name, age, address, studentId, course);
        this.researchTopic = researchTopic;
    }

    public void submitThesis() {
        System.out.println(name + " has submitted a thesis on " + researchTopic);
    }
}

// Main class to test the hierarchy
public class UniversityTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];
        
        people[0] = new Professor("Dr. Smith", 50, "123 University Ave", 1001, "Computer Science", "Artificial Intelligence");
        people[1] = new GraduateStudent("Alice", 25, "456 College St", 2001, "MSc Computer Science", "Quantum Computing");
        
        for (Person person : people) {
            person.displayDetails();
            if (person instanceof Professor) {
                ((Professor) person).conductLecture();
            } else if (person instanceof GraduateStudent) {
                ((GraduateStudent) person).submitThesis();
            }
            System.out.println();
        }
    }
}

