# ☕ Java Object-Oriented Programming (OOP) Reference

Object-Oriented Programming is the foundational paradigm of Java. It is designed around mapping real-world entities to structured software objects.

---

## 🔑 1. Classes, Objects & Constructors

*   **Class:** A blueprint or template that defines the properties (fields) and behaviors (methods) of a specific type of object.
*   **Object:** A concrete instance of a class. Memory is allocated for fields when an object is instantiated.
*   **Constructor:** A special method block called during object instantiation to initialize properties. It has no return type and shares the exact name of the class.

```java
public class Book {
    // Fields / Attributes
    private String title;
    private double price;

    // Parameterized Constructor
    public Book(String title, double price) {
        this.title = title; // 'this' resolves naming conflict with local parameters
        this.price = price;
    }
}
```

---

## 🌟 2. The Four Pillars of OOP

### I. Encapsulation (Data Hiding)
*   **Definition:** Restricting direct access to an object's fields to protect internal state. Access is channeled via public Getter and Setter methods.
*   **Benefits:** Modularity, input validation inside setter blocks, read-only/write-only properties.
*   **Implementation:** Marking fields `private` and exposing public methods.

```java
public class Account {
    private double balance; // Access restricted

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount > 0) { // Validation logic
            this.balance += amount;
        }
    }
}
```

### II. Inheritance (Code Reuse)
*   **Definition:** The mechanism where one class (subclass/child) acquires the fields and methods of another class (superclass/parent) using the `extends` keyword.
*   **Keyword `super`:** Refers to the immediate parent class's constructor, methods, or fields.
*   **Note:** Java supports **single inheritance** (a class can only extend one direct superclass).

```java
class Device {
    protected String brand;

    public Device(String brand) {
        this.brand = brand;
    }
}

class Phone extends Device {
    private int storage;

    public Phone(String brand, int storage) {
        super(brand); // Calls parent constructor
        this.storage = storage;
    }
}
```

### III. Polymorphism (Many Forms)
*   **Definition:** The ability of an object or method to behave differently under different contexts.
*   **Compile-time (Static) Polymorphism:** Method Overloading (methods in same class with different parameters).
*   **Run-time (Dynamic) Polymorphism:** Method Overriding (child class overrides parent class method with `@Override`). Resolved at runtime using dynamic binding.

```java
class Animal {
    public void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark"); // Run-time polymorphism
    }
}
```

### IV. Abstraction (Hiding Complexity)
*   **Definition:** Hiding implementation details and showing only key operations to users.
*   **Abstract Classes:** Classes declared with `abstract` that cannot be instantiated. Can contain both abstract (without body) and concrete methods.
*   **Interfaces:** Pure abstract blueprints specifying methods a class must implement (using the `implements` keyword). Supports multiple inheritance behaviors.

```java
// Abstract Class
abstract class Database {
    abstract void connect(); // Abstract method
    
    void disconnect() {
        System.out.println("Disconnected."); // Concrete method
    }
}

// Interface
interface Printable {
    void printDetails(); // Implicitly public abstract
}
```
