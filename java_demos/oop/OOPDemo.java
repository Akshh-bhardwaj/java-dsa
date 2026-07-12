public class OOPDemo {
    public static void main(String[] args) {
        System.out.println("--- OOP Principles Demo ---");

        // Polymorphism: Reference of type Vehicle pointing to Car object
        Vehicle myVehicle = new Car("Tesla", 4);
        
        System.out.println("Accessing Brand: " + myVehicle.getBrand());
        myVehicle.startEngine(); // Polymorphic method call

        // Interface access
        if (myVehicle instanceof Printable) {
            ((Printable) myVehicle).printInfo();
        }
    }
}

// Interface
interface Printable {
    void printInfo();
}

// Parent Abstract Class (Abstraction)
abstract class Vehicle {
    private final String brand; // Encapsulation: private field, final constant

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public String getBrand() { // Encapsulation: Getter
        return brand;
    }

    // Abstract method (no implementation)
    public abstract void startEngine();
}

// Child Class (Inheritance)
class Car extends Vehicle implements Printable {
    private final int doors;

    public Car(String brand, int doors) {
        super(brand); // Call to parent constructor
        this.doors = doors;
    }

    // Method Overriding (Run-time Polymorphism)
    @Override
    public void startEngine() {
        System.out.println(getBrand() + " engine started with a roar!");
    }

    // Interface implementation
    @Override
    public void printInfo() {
        System.out.println("Car Brand: " + getBrand() + ", Doors: " + doors);
    }
}
