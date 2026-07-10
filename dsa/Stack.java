package dsa;

public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Empty stack indicator
    }

    // Push item onto stack
    public boolean push(int val) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + val);
            return false;
        }
        stackArray[++top] = val;
        return true;
    }

    // Pop item from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Stack is empty.");
            return -1; // Error sentinel
        }
        return stackArray[top--];
    }

    // Peek top item
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stackArray[top];
    }

    // Check if empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Check if full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Display stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("--- Stack Test ---");
        Stack s = new Stack(3);
        s.push(5);
        s.push(10);
        s.push(15);
        s.push(20); // Overflow test
        s.display(); // 15 10 5

        System.out.println("Peek: " + s.peek()); // 15
        System.out.println("Popped: " + s.pop()); // 15
        s.display(); // 10 5
    }
}
