package vehicles;

public class Truck extends Vehicle {
    public Truck(String model) {
        super(model, 4);
    }

    @Override
    public int maxSpeed() {
        return 120;
    }
}
