# ☕ Java Exceptions & File I/O Reference

Guidelines on runtime error handling and filesystem input/output interactions.

---

## 🛠️ 1. Exception Handling

An **exception** is an unwanted or unexpected event that occurs during program execution, disrupting the normal flow of instructions.

### Exception Hierarchy
```text
                  Throwable
                  /       \
             Error         Exception
                            /      \
               RuntimeException     IOException
              (Unchecked/Bug)      (Checked/IO)
```
*   **Checked Exceptions:** Checked at compile-time (e.g., `IOException`, `FileNotFoundException`). The compiler forces you to handle them using `try-catch` or specify them using `throws`.
*   **Unchecked (Runtime) Exceptions:** Occur at runtime (e.g., `NullPointerException`, `ArrayIndexOutOfBoundsException`). Caused by programming errors.

### Try-Catch-Finally Pattern
*   `try`: Encloses code that might throw an exception.
*   `catch`: Handles the specific exception if it occurs.
*   `finally`: Code block that always executes, regardless of whether an exception was thrown or caught (used to clean up resources like db connections or files).

```java
try {
    int result = 10 / 0; // Throws ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Error: Divided by zero!");
} finally {
    System.out.println("Execution complete.");
}
```

### Custom Exceptions
To build your own domain-specific errors, extend `Exception` (for checked) or `RuntimeException` (for unchecked).
```java
// Custom Unchecked Exception
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}

class Test {
    static void checkAge(int age) {
        if (age < 18) {
            throw new InvalidAgeException("Access denied - Under 18");
        }
    }
}
```

---

## 📂 2. File Input/Output (I/O)

Reading and writing files is standard in many systems. In modern Java, standard tools include `BufferedReader`, `BufferedWriter`, and `try-with-resources` (which automatically closes resource streams).

### Writing to a File
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileExample {
    public static void main(String[] args) {
        // Try-with-resources automatically closes the writer
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("Hello, World!");
            writer.newLine();
            writer.write("Java I/O is running.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Reading from a File
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
