import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class CollectionsDemo {
    public static void main(String[] args) {
        System.out.println("--- Collections Framework Demo ---");

        // 1. List (Ordered list of elements, duplicates allowed)
        System.out.println("\n[1. List Demo (ArrayList)]");
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apple"); // Duplicate element
        System.out.println("ArrayList elements: " + list);
        System.out.println("Element at index 1: " + list.get(1));

        // 2. Set (Unordered elements, duplicates NOT allowed)
        System.out.println("\n[2. Set Demo (HashSet)]");
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(10); // Duplicate is ignored
        System.out.println("HashSet elements: " + set);
        System.out.println("Contains 10? " + set.contains(10));

        // 3. Map (Key-Value associations, keys unique)
        System.out.println("\n[3. Map Demo (HashMap)]");
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 90);
        map.put("Bob", 85);
        map.put("Alice", 95); // Overwrites key "Alice"
        System.out.println("HashMap entries: " + map);
        System.out.println("Alice's Score: " + map.get("Alice"));

        // 4. Queue (FIFO element retrieval / Min-Heap Priority Queue)
        System.out.println("\n[4. Queue Demo (PriorityQueue - Min-Heap)]");
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(40);
        pq.add(10);
        pq.add(30);
        System.out.println("PriorityQueue head (peek): " + pq.peek()); // Smallest first
        System.out.print("Polling elements: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " "); // Retrieves and removes smallest element
        }
        System.out.println();
    }
}
