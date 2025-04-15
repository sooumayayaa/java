
import java.util.Scanner;
// Base class
abstract class TrunkCall {
    protected int duration;
    public TrunkCall(int duration) {
        this.duration = duration;}
    // Abstract method to calculate charges
    public abstract double calculateCharge();}
// Ordinary call class
class OrdinaryCall extends TrunkCall {
    private static final double RATE = 1.0; // Example rate per minute
    public OrdinaryCall(int duration) {
        super(duration);}
    @Override
    public double calculateCharge() {
        return duration * RATE;}}
// Urgent call class
class UrgentCall extends TrunkCall {
    private static final double RATE = 2.0;
    public UrgentCall(int duration) {
        super(duration);
    }
    @Override
    public double calculateCharge() {
        return duration * RATE; }}
// Lightning call class
class LightningCall extends TrunkCall {
    private static final double RATE = 3.0;
    public LightningCall(int duration) {
        super(duration); }
    @Override
    public double calculateCharge() {
        return duration * RATE;}}
// Main class
public class TrunkCallCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter call duration in minutes:");
        int duration = scanner.nextInt();
        
        System.out.println("Enter call type (Ordinary, Urgent, Lightning):");
        String callType = scanner.next();

        TrunkCall call;
        
        switch (callType.toLowerCase()) {
            case "ordinary":
                call = new OrdinaryCall(duration);
                break;
            case "urgent":
                call = new UrgentCall(duration);
                break;
            case "lightning":
                call = new LightningCall(duration);
                break;
            default:
                System.out.println("Invalid call type!");
                scanner.close();
                return;
        }
        
        System.out.println("Total charge: Rs. " + call.calculateCharge());
        scanner.close();
    }
}
