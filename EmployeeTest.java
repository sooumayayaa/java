import java.util.Scanner;

// Employee class
class Employee {
    protected String name;
    protected int empId;
    protected double salary;

    // Default constructor
    public Employee() {
        this.name = "Unknown";
        this.empId = 0;
        this.salary = 0.0;
    }

    // Parameterized constructor
    public Employee(String name, int empId, double salary) {
        this.name = name;
        this.empId = empId;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double percentage) {
        if (percentage > 0) {
            salary += salary * (percentage / 100);
        }
    }
}

// Manager subclass
class Manager extends Employee {
    private String department;

    public Manager(String name, int empId, double salary, String department) {
        super(name, empId, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

// Test program
public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Employee Name:");
        String name = scanner.nextLine();
        
        System.out.println("Enter Employee ID:");
        int empId = scanner.nextInt();
        
        System.out.println("Enter Employee Salary:");
        double salary = scanner.nextDouble();
        
        Employee emp = new Employee(name, empId, salary);
        
        System.out.println("Enter percentage increase in salary:");
        double percentage = scanner.nextDouble();
        emp.increaseSalary(percentage);
        
        System.out.println("Updated Salary of " + emp.getName() + " is: Rs. " + emp.getSalary());
        
        // Testing Manager subclass
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Manager Department:");
        String department = scanner.nextLine();
        
        Manager manager = new Manager(name, empId, salary, department);
        System.out.println("Manager " + manager.getName() + " heads " + manager.getDepartment() + " department.");
        
        scanner.close();
    }
}

