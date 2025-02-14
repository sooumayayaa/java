class Worker {
    String name;
    double salaryRate;

    public Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }

    public double computePay(int hours) {
        return 0; // Overridden by subclasses
    }
}
class DailyWorker extends Worker {
    public DailyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    @Override
    public double computePay(int hours) {
        int daysWorked = hours / 8; // Assuming 8 hours per day
        return daysWorked * salaryRate;
    }
}
class SalariedWorker extends Worker {
    public SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }
    @Override
    public double computePay(int hours) {
        return 40 * salaryRate; // Fixed pay for 40 hours per week
    }
}
public class WorkerDemo {
    public static void main(String[] args) {
        Worker dw = new DailyWorker("John", 100); // Paid per day
        Worker sw = new SalariedWorker("Alice", 50); // Fixed weekly pay

        System.out.println(dw.name + "'s Weekly Pay: $" + dw.computePay(48)); // 48 hours worked (6 days)
        System.out.println(sw.name + "'s Weekly Pay: $" + sw.computePay(60)); // 60 hours but fixed salary
    }}
