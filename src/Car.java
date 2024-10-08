import java.time.Year;

public class Car {
    protected String brand;
    protected String model;
    protected int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public static void getAttributes(Car car) {
        System.out.println("Brand: " + car.brand);
        System.out.println("Model: " + car.model);
        System.out.println("Year: " + car.year);
    }

    public int getAge() {
        return Year.now().getValue() - this.year;
    }
}
