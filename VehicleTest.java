import java.util.Scanner;

// Base class
class Vehicle {
    protected String brand;
    protected String model;
    protected double price;

    public Vehicle(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Price: Rs. " + price);
    }
}

// Car class extending Vehicle
class Car extends Vehicle {
    protected int seatingCapacity;
    protected String fuelType;

    public Car(String brand, String model, double price, int seatingCapacity, String fuelType) {
        super(brand, model, price);
        this.seatingCapacity = seatingCapacity;
        this.fuelType = fuelType;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Seating Capacity: " + seatingCapacity + ", Fuel Type: " + fuelType);
    }
}

// ElectricCar extending Car
class ElectricCar extends Car {
    private int batteryCapacity;
    private double chargingTime;

    public ElectricCar(String brand, String model, double price, int seatingCapacity, String fuelType, int batteryCapacity, double chargingTime) {
        super(brand, model, price, seatingCapacity, fuelType);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh, Charging Time: " + chargingTime + " hours");
    }
}

// Motorcycle class extending Vehicle
class Motorcycle extends Vehicle {
    private int engineCapacity;
    private String type;

    public Motorcycle(String brand, String model, double price, int engineCapacity, String type) {
        super(brand, model, price);
        this.engineCapacity = engineCapacity;
        this.type = type;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Engine Capacity: " + engineCapacity + " cc, Type: " + type);
    }
}

// Main class to test the hierarchy
public class VehicleTest {
    public static void main(String[] args) {
        // Creating and displaying an ElectricCar
        try (Scanner scanner = new Scanner(System.in)) {
            // Creating and displaying an ElectricCar
            ElectricCar tesla = new ElectricCar("Tesla", "Model S", 75000, 5, "Electric", 100, 1.5);
            System.out.println("Electric Car Details:");
            tesla.displayDetails();
            
            // Creating and displaying a Motorcycle
            Motorcycle yamaha = new Motorcycle("Yamaha", "R1", 20000, 998, "Sport");
            System.out.println("\nMotorcycle Details:");
            yamaha.displayDetails();
        }
    }
}
