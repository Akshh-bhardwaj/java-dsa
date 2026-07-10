# 📦 Java Collections Framework Reference

The Java Collections Framework provides an architecture to store and manipulate groups of objects. It offers pre-built, optimized implementations of standard data structures.

---

## 📚 Collections Framework Hierarchy

```text
               Collection (Interface)
             /       |            \
     List (Intf)  Set (Intf)    Queue (Intf)
      /    \          |              |
ArrayList LinkedList HashSet    PriorityQueue
                             (Map is standalone)
```

---

## ⚡ Core Data Structures Summary

### 1. Lists (Ordered Collections)
*   **ArrayList:** Backed by a dynamic array. Excellent for random reads, slow for insertions/deletions in the middle.
*   **LinkedList:** Backed by a doubly-linked list. Fast insertion/deletion, slow random access (requires traversal).

| Operation | ArrayList | LinkedList |
| :--- | :--- | :--- |
| **Get (index)** | $O(1)$ | $O(N)$ |
| **Add (end)** | $O(1)$ (amortized) | $O(1)$ |
| **Add (middle)** | $O(N)$ | $O(N)$ (to traverse) |
| **Remove (index)**| $O(N)$ | $O(N)$ |

```java
import java.util.ArrayList;
import java.util.List;

List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
String fruit = list.get(0); // "Apple"
```

---

### 2. Sets (No Duplicates)
*   **HashSet:** Backed by a Hash Table. Unordered, allows null, elements must implement `hashCode()` and `equals()`.
*   **TreeSet:** Backed by a Red-Black tree. Elements sorted in natural ascending order ($O(\log N)$ search/insert).

| Operation | HashSet | TreeSet |
| :--- | :--- | :--- |
| **Add** | $O(1)$ | $O(\log N)$ |
| **Contains** | $O(1)$ | $O(\log N)$ |
| **Remove** | $O(1)$ | $O(\log N)$ |

```java
import java.util.HashSet;
import java.util.Set;

Set<Integer> set = new HashSet<>();
set.add(10);
set.add(10); // Duplicate ignored
boolean hasTen = set.contains(10); // true
```

---

### 3. Maps (Key-Value Pairs)
*Note: Map does not extend the `Collection` interface directly, but is considered part of the framework.*
*   **HashMap:** Unordered hash table representation.
*   **TreeMap:** Sorted by keys ($O(\log N)$ operations).

| Operation | HashMap | TreeMap |
| :--- | :--- | :--- |
| **Put (insert)** | $O(1)$ | $O(\log N)$ |
| **Get (lookup)** | $O(1)$ | $O(\log N)$ |
| **ContainsKey** | $O(1)$ | $O(\log N)$ |

```java
import java.util.HashMap;
import java.util.Map;

Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 90);
scores.put("Bob", 85);
int aliceScore = scores.get("Alice"); // 90
```

---

### 4. Queues & Deques (FIFO / LIFO)
*   **Queue:** First-In-First-Out element processing.
*   **PriorityQueue:** Sorts elements based on natural order or a custom `Comparator` (Min-Heap by default).
*   **ArrayDeque:** Double-ended queue implementation. Faster than Stack/LinkedList.

```java
import java.util.PriorityQueue;
import java.util.Queue;

Queue<Integer> pq = new PriorityQueue<>(); // Min-Heap
pq.add(30);
pq.add(10);
pq.add(20);
int smallest = pq.poll(); // Returns 10 (smallest element removed)
```
