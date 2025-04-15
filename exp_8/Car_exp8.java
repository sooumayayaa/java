
class Car_exp7 {
    // Inner Class
    class Engine {
        void start() {
            System.out.println("Engine started");
        }

        void stop() {
            System.out.println("Engine stopped");
        }
    }

    void drive() {
        Engine engine = new Engine();
        engine.start();
        System.out.println("Car is driving...");
        engine.stop();
    }

    public static void main(String[] args) {
        Car_exp7 myCar = new Car_exp7();
        myCar.drive();
    }
}


