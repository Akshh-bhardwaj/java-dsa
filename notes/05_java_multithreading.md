# ☕ Java Multithreading & Concurrency Reference

Multithreading is the capability to run multiple threads of execution concurrently inside a single Java process to optimize CPU usage.

---

## 🧵 1. Creating Threads

Java offers two mechanisms for defining executable threads:

### I. Extending the `Thread` Class
```java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Running Thread: " + Thread.currentThread().getName());
    }
}

// Running the thread:
MyThread t1 = new MyThread();
t1.start(); // Triggers run() method asynchronously
```

### II. Implementing the `Runnable` Interface (Recommended)
This approach is preferred since Java doesn't support multiple inheritance (your class can implement other interfaces and extend a parent class).
```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Running Runnable: " + Thread.currentThread().getName());
    }
}

// Running the thread:
Thread t2 = new Thread(new MyRunnable());
t2.start();
```

---

## 🔄 2. Thread Lifecycle States

A thread is always in one of the following states:
1.  **New:** A thread object is created, but `start()` has not been called.
2.  **Runnable:** Ready to execute, waiting for CPU resource scheduling.
3.  **Running:** CPU is actively executing the thread code.
4.  **Blocked/Waiting:** Suspended, waiting for a monitor lock or notify signal (e.g., waiting for I/O or synchronized block).
5.  **Timed Waiting:** Sleeping or waiting with a timeout (e.g., `Thread.sleep(1000)`).
6.  **Terminated:** Finished executing its task.

---

## 🔒 3. Synchronization (Preventing Race Conditions)

When multiple threads access shared mutable data concurrently, a **race condition** can occur, leading to data corruption.

### Using the `synchronized` Keyword
Synchronization locks access to a resource so only one thread can execute it at a time.

```java
class Counter {
    private int count = 0;

    // Synchronized method locks 'this' object instance
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
```

---

## ⚡ 4. Modern Concurrency: Thread Pools

Manually spawning threads is expensive. In production, use **ExecutorService** to manage a reusable pool of threads.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed pool containing 3 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing task " + taskId + " via " + Thread.currentThread().getName());
            });
        }

        executor.shutdown(); // Gracefully stops accepting new tasks
    }
}
```
