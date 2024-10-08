package vehicles;

public class Vehicle {
    protected String model;
    protected int numberOfWheels;

    public Vehicle(String model, int numberOfWheels) {
        this.model = model;
        this.numberOfWheels = numberOfWheels;
    }

    public static void getAttributes(Vehicle vehicle) {
        System.out.println("Model: " + vehicle.model);
        System.out.println("Number of wheels: " + vehicle.numberOfWheels);
    }

    public int maxSpeed() {
        return 0;
    }
}
