import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Concurrency & Multithreading Demo ---");

        // 1. Thread Spawning Methods
        System.out.println("\n[1. Spawning Threads]");
        CustomThread t1 = new CustomThread();
        Thread t2 = new Thread(new CustomRunnable());

        t1.start(); // Triggers CustomThread run() concurrently
        t2.start(); // Triggers CustomRunnable run() concurrently

        // Join makes current thread wait until t1/t2 complete
        t1.join();
        t2.join();

        // 2. Synchronized Race Protection
        System.out.println("\n[2. Synchronization Check]");
        SynchronizedCounter counter = new SynchronizedCounter();

        // Spawn two threads incrementing the same counter concurrently
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

        System.out.println("Final synchronized count (should be 2000): " + counter.getCount());

        // 3. ExecutorService Thread Pools
        System.out.println("\n[3. ExecutorService Thread Pool]");
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            pool.submit(() -> {
                System.out.println("Task #" + taskId + " running inside thread pool: " + Thread.currentThread().getName());
            });
        }

        pool.shutdown(); // Gracefully stop receiving new tasks
        // Wait for tasks to complete (up to 5 seconds)
        pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Thread pool shutdown successfully.");
    }
}

// Shared resource for synchronization demo
class SynchronizedCounter {
    private int count = 0;

    // Synchronized keyword locks the method block on 'this' counter instance
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

// Extends Thread class
class CustomThread extends Thread {
    @Override
    public void run() {
        System.out.println("Extending Thread: Running in " + Thread.currentThread().getName());
    }
}

// Implements Runnable interface
class CustomRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Implementing Runnable: Running in " + Thread.currentThread().getName());
    }
}
