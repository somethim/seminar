package vehicles;

public class Bike extends Vehicle {

    public Bike(String model) {
        super(model, 2);
    }

    public static void getAttributes(Bike bike) {
        Vehicle.getAttributes(bike);
    }

    @Override
    public int maxSpeed() {
        return 80;
    }
}
