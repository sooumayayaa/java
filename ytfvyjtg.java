class Student {
    private String name;
    private int age;
    // Default constructor
    public Student() {
        this.name = "Default Name";
        this.age = 18;
    }
    // Parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void display() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }
    public static void main(String[] args) {
        // Creating an object using the default constructor
        Student student1 = new Student();
        student1.display();

        // Creating an object using the parameterized constructor
        Student student2 = new Student("Alice", 20);
        student2.display();
    }
}
