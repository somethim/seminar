import animals.Animal;
import animals.Cat;
import animals.Dog;
import instruments.Guitar;
import instruments.Piano;
import instruments.Playable;
import libraries.Book;
import libraries.Library;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        instrument();
        animal();
        vehicle();
        createLibraryAndBooks();
        getLibraryAndBooks();
        shapes();
    }

    private static void shapes() {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Circle(3);

        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.area());
        }
    }

    private static HashMap<String, String> getAttributesFromUser() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> attributes = new HashMap<>();

        System.out.println("Enter the brand of the car: ");
        attributes.put("brand", scanner.nextLine());

        System.out.println("Enter the model of the car: ");
        attributes.put("model", scanner.nextLine());

        System.out.println("Enter the year of the car: ");
        attributes.put("year", scanner.nextLine());

        return attributes;
    }

    private static void getLibraryAndBooks() {
        for (Library library : Library.libraries()) {
            Library.getAttributes(library);
            Library.relatedBooks(library);
        }

    }

    private static void createLibraryAndBooks() {
        while (Library.getLastId() < 5) {
            library();
        }

        Library[] libraries = Library.libraries();

        for (Library library : libraries) {
            book(library);
        }
    }

    private static void instrument() {
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        guitar.play();
        piano.play();
    }

    private static void animal() {
        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.makeSound();
        cat.makeSound();
    }

    private static void vehicle() {
        HashMap<String, String> attributes = getAttributesFromUser();

        String brand = !Objects.equals(attributes.get("brand"), "") ? attributes.get("brand") : "Toyota";
        String model = !Objects.equals(attributes.get("model"), "") ? attributes.get("model") : "Corolla";
        int year = !Objects.equals(attributes.get("year"), "") ? Integer.parseInt(attributes.get("year")) : 2020;

        Car car = new Car(brand, model, year);
        Car.getAttributes(car);
        System.out.println("Age: " + car.getAge());
    }

    private static void library() {
        new Library("Library_" + Library.getLastId());
    }

    private static void book(Library library) {
        new Book("Title", "Author", "ISBN", library.getId());
    }
}
