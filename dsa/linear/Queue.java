package dsa.linear;

public class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    // Constructor
    public Queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Add item to queue (Enqueue)
    public boolean enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot enqueue " + item);
            return false;
        }
        
        // Circular insertion
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
        return true;
    }

    // Remove item from queue (Dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Queue is empty.");
            return -1;
        }
        
        int val = arr[front];
        // Circular modification
        front = (front + 1) % capacity;
        count--;
        return val;
    }

    // Peek front item
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return arr[front];
    }

    // Helper functions
    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (count == capacity);
    }

    public int size() {
        return count;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("--- Queue Test ---");
        Queue q = new Queue(3);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40); // Overflow test
        q.display(); // 10 20 30

        System.out.println("Dequeued: " + q.dequeue()); // 10
        q.enqueue(40); // Works because space cleared
        q.display(); // 20 30 40
    }
}
