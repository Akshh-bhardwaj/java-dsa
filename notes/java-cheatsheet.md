# ☕ Java Basics Cheatsheet

A concise reference sheet of Java fundamentals, syntax, operators, control flow, loops, arrays, methods, strings, and standard classes.

---

## 📚 Table of Contents
1. [Boilerplate & Output](#1-boilerplate--output)
2. [Input (Scanner)](#2-input-scanner)
3. [Data Types & Comments](#3-data-types--comments)
4. [Constants & Operators](#4-constants--operators)
5. [Escape Sequences & Type Casting](#5-escape-sequences--type-casting)
6. [Control Flow](#6-control-flow)
7. [Loops](#7-loops)
8. [Arrays](#8-arrays)
9. [Methods & Recursion](#9-methods--recursion)
10. [String & Math Classes](#10-string--math-classes)

---

## 1. Boilerplate & Output
Every program in Java must run inside a class definition, and the entry point is the `main` method.

### Boilerplate Code
```java
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```
*   `public` $\rightarrow$ Access modifier (required so the JVM can execute the class entry point from anywhere).
*   `static` $\rightarrow$ Allows the JVM to call this method without instantiating an object of the class.
*   `void` $\rightarrow$ Signifies that the method returns no value.
*   `String[] args` $\rightarrow$ Array parameter capturing command-line arguments.

### Showing Output
```java
System.out.print("Hello");           // Prints text without a trailing newline
System.out.println(" World");       // Prints text and appends a newline at the end
System.out.printf("Age: %d", 20);    // Formatted output (like printf in C)
```

---

## 2. Input (Scanner)
The `Scanner` class in `java.util` package is used to scan keyboard input.

```java
import java.util.Scanner;

class InputExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter name: ");
        String name = sc.nextLine();      // Reads a full line of text
        
        System.out.print("Enter age: ");
        int age = sc.nextInt();           // Reads an integer
        
        System.out.print("Enter float: ");
        float f = sc.nextFloat();         // Reads a float
        
        System.out.print("Enter double: ");
        double d = sc.nextDouble();       // Reads a double
        
        System.out.print("Enter boolean: ");
        boolean b = sc.nextBoolean();     // Reads a boolean (true/false)
        
        System.out.print("Enter character: ");
        char c = sc.next().charAt(0);     // Reads the first character of the next word
        
        System.out.println("Name: " + name);
        sc.close();
    }
}
```

---

## 3. Data Types & Comments
Java is a statically typed language. Every variable must have a declared type.

### Primitive Types
Java has 8 primitive data types built into the language:

| Type | Size | Range / Representation | Literal Example |
| :--- | :--- | :--- | :--- |
| `byte` | 8-bit | -128 to 127 | `(byte) 10` |
| `short` | 16-bit | -32,768 to 32,767 | `(short) 50` |
| `int` | 32-bit | -2,147,483,648 to 2,147,483,647 (default integer) | `45` |
| `long` | 64-bit | -9.22 Quintillion to 9.22 Quintillion | `999999999L` (append `L`) |
| `float` | 32-bit | Floating-point (decimal representation) | `3.14f` (append `f`) |
| `double` | 64-bit | Double-precision decimal (default float) | `45.9` |
| `boolean` | 1-bit | `true` or `false` | `true` |
| `char` | 16-bit | Single character (Unicode representation) | `'A'` |

### Comments
```java
// This is a single-line comment

/* 
   This is a multi-line comment
   spanning multiple lines.
*/

/** 
 * This is a Javadoc comment.
 * Used to generate API documentation from source code.
 */
```

---

## 4. Constants & Operators

### Constants
Constants are defined using the `final` keyword. Their value cannot be modified once initialized.
```java
final double PI = 3.14159;
static final int MAX_LIMIT = 100; // Commonly static when declared at class-level
```

### Operators
*   **Arithmetic:** `+` (addition), `-` (subtraction), `*` (multiplication), `/` (division), `%` (modulo), `++` (increment), `--` (decrement).
    *   *Note:* Division between two integers truncates the decimal part (integer division).
*   **Assignment:** `=`, `+=`, `-=`, `*=`, `/=`, `%=`
*   **Comparison:** `==` (equal to), `!=` (not equal to), `>` (greater than), `<` (less than), `>=` (greater than or equal to), `<=` (less than or equal to).
*   **Logical:** `&&` (AND), `||` (OR), `!` (NOT).

---

## 5. Escape Sequences & Type Casting

### Escape Sequences
*   `\n` $\rightarrow$ Newline
*   `\t` $\rightarrow$ Tab indentation
*   `\\` $\rightarrow$ Backslash literal
*   `\'` $\rightarrow$ Single quote literal
*   `\"` $\rightarrow$ Double quote literal
*   `\r` $\rightarrow$ Carriage return
*   `\b` $\rightarrow$ Backspace
*   *Note:* `\?` is not valid in Java; use `?` directly.

### Type Casting
*   **Widening (automatic):** Converts a smaller type to a larger type without data loss.
    ```java
    int x = 45;
    double y = x; // Automatic widening conversion (int -> double)
    ```
*   **Narrowing (manual):** Converts a larger type to a smaller type. Requires explicit casting and truncates decimal values.
    ```java
    double d = 45.9;
    int n = (int) d; // n = 45 (explicit casting, truncates decimals)
    ```

---

## 6. Control Flow

### `if / else if / else`
```java
if (x > 0) {
    System.out.println("Positive");
} else if (x == 0) {
    System.out.println("Zero");
} else {
    System.out.println("Negative");
}
```

### Ternary Operator
```java
String result = (x > 0) ? "Positive" : "Negative";
```

### `switch` Statement (Supports Strings since Java 7)
```java
switch(day) {
    case 1: 
        System.out.println("Mon"); 
        break;
    case 2: 
        System.out.println("Tue"); 
        break;
    default: 
        System.out.println("Invalid day");
}
```

---

## 7. Loops

### `while` Loop
Checks condition before executing loop body.
```java
while (i < 5) {
    i++;
}
```

### `do-while` Loop
Executes loop body once *before* checking the condition.
```java
do {
    i++;
} while (i < 5);
```

### `for` Loop
```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

### `for-each` (Enhanced `for`) Loop
Used for iterating through arrays or collections.
```java
for (int n : arr) {
    System.out.println(n);
}
```

### `break` vs `continue`
*   `break` $\rightarrow$ Exits the loop block immediately.
*   `continue` $\rightarrow$ Skips the remaining code inside the loop for the current iteration and goes to the next evaluation.

---

## 8. Arrays

### Single-Dimensional Arrays
```java
int[] nums = new int[5]; // Allocate memory for 5 integers (initialized to 0)
String[] names = {"Harry", "Rohan"}; // Initialize array directly

System.out.println(names.length); // Print array length (Output: 2)
```

### Multi-Dimensional Arrays
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

System.out.println(matrix[1][2]); // Access row 1, column 2 (Output: 6)
```

---

## 9. Methods & Recursion

### Methods
```java
class MethodDemo {
    // Defined a static method that takes two parameters and returns an int
    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(add(5, 10)); // Output: 15
    }
}
```

### Method Overloading
Multiple methods can have the same name but different signatures (different parameter counts or types).
```java
void sum(int a, int b) { ... }
void sum(double a, double b) { ... }
```

### Recursion
A method calling itself. Example finding the factorial of $N$:
```java
int fact(int n) {
    if (n == 0) return 1; // Base case
    return n * fact(n - 1); // Recursive call
}
```

---

## 10. String & Math Classes

### String Class
Strings are objects of class `java.lang.String` and are immutable.

```java
String s = "Hello";
int len = s.length();          // String length (5)
s.toUpperCase();               // Returns "HELLO" (original string s remains unchanged)
s.toLowerCase();               // Returns "hello"
s.indexOf("l");                // Returns index of character 'l' (first occurrence: 2)
s.contains("He");              // Returns true if substring exists
s.equals("Hello");             // Content equality comparison (returns true)
s.equalsIgnoreCase("hello");   // Content equality ignoring case (returns true)
s.substring(0, 3);             // Extracts substring from index 0 up to 3 (exclusive) -> "Hel"
s.replace("H", "J");           // Returns "Jello"
```

### Math Class
Provides utility methods for basic numeric operations.
```java
Math.max(5, 10);    // Returns larger value (10)
Math.min(5, 10);    // Returns smaller value (5)
Math.sqrt(16);      // Returns square root (4.0)
Math.pow(2, 3);     // Returns power evaluation (2^3 = 8.0)
Math.abs(-10);      // Returns absolute value (10)
Math.random();      // Returns random double value in the range [0.0, 1.0)
```
