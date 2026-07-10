# ☕ Java & DSA Master Blueprint

Welcome to the **Java & DSA Master Blueprint**! This repository is a comprehensive learning curriculum and implementation suite designed for mastering Java language core concepts, foundational Data Structures & Algorithms (DSA), and standard LeetCode coding interview problems.

> 🚀 **Designed for the Feed:** This repository is structured to document learning progress, highlight clean-code practices, and serve as a complete cheatsheet to share with the developer community.

---

## 📂 Directory Structure

The repository is organized into distinct tracks for theory, implementations, and problem-solving:

```text
java-dsa/
├── README.md
├── notes/                   # 📝 Full Java Theory Guides
│   ├── java-cheatsheet.md   # 01. Language Basics
│   ├── 02_java_oop.md       # 02. OOP Design & 4 Pillars
│   ├── 03_java_collections.md # 03. Collections Framework
│   ├── 04_java_exceptions_io.md # 04. Exception Handling & File I/O
│   └── 05_java_multithreading.md # 05. Multithreading & Thread Pools
│
├── dsa/                     # 📊 Production-Grade DSA Code
│   ├── linear/              # Linear Structures
│   │   ├── SinglyLinkedList.java
│   │   ├── DoublyLinkedList.java
│   │   ├── Stack.java
│   │   └── Queue.java
│   ├── trees/               # Hierarchical Structures
│   │   └── BinarySearchTree.java
│   ├── graphs/              # Network Structures
│   │   └── Graph.java
│   ├── searching/           # Search Routines
│   │   └── BinarySearch.java
│   └── sorting/             # Sorting Algorithms
│       └── SortingAlgorithms.java
│
└── leetcode/                # 🎯 Curated Interview Solutions
    ├── TwoSum.java          # HashMap Lookups
    ├── ValidAnagram.java    # Array buckets / frequency hashing
    ├── ValidParentheses.java # Stack LIFO validation
    ├── ReverseList.java     # Linked list swaps (Iterative & Recursive)
    ├── InvertBinaryTree.java # BST DFS tree inversion
    └── ClimbingStairs.java  # 1D Dynamic Programming
```

---

## 📚 Curriculum Index

### 1. 📝 Full Java Reference Guides (`notes/`)

Detailed cheatsheets with sample code blocks and complexity analysis:
1.  **[01_java_basics.md](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/notes/java-cheatsheet.md):** Variables, input scanning, operators, escape sequences, casting, control flow, loops, methods, arrays, `String`, and `Math` classes.
2.  **[02_java_oop.md](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/notes/02_java_oop.md):** Core classes/objects, constructors, Encapsulation, Inheritance, Polymorphism, Abstraction, abstract classes, and Interfaces.
3.  **[03_java_collections.md](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/notes/03_java_collections.md):** Collections framework hierarchy (`List`, `Set`, `Map`, `Queue`), concrete implementations (`ArrayList`, `LinkedList`, `HashSet`, `HashMap`, `PriorityQueue`), and time complexity matrices.
4.  **[04_java_exceptions_io.md](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/notes/04_java_exceptions_io.md):** Error exception hierarchy (checked vs. unchecked), try-catch-finally blocks, custom exception classes, and `BufferedReader`/`FileWriter` streams.
5.  **[05_java_multithreading.md](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/notes/05_java_multithreading.md):** Async threads creation (`Thread` extension vs. `Runnable` implementation), thread life-cycle, monitor synchronization blocks, and modern `ExecutorService` thread pooling.

---

### 2. 📊 Full Data Structures & Algorithms (`dsa/`)

Modular, self-contained implementations of core computer science structures:

| Category | File | Description | Complexity | Operations Covered |
| :--- | :--- | :--- | :--- | :--- |
| **Linear** | [SinglyLinkedList.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/dsa/linear/SinglyLinkedList.java) | Singly Linked List | $O(N)$ insertion/deletion | Head/tail append, search and element removal. |
| **Linear** | [DoublyLinkedList.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/dsa/linear/DoublyLinkedList.java) | Doubly Linked List | $O(N)$ insertion/deletion | Prev/next node link, forward and backward traversal. |
| **Linear** | [Stack.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/dsa/linear/Stack.java) | LIFO Buffer | $O(1)$ push/pop | Array buffer representation, Overflow/Underflow safety checks. |
| **Linear** | [Queue.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/dsa/linear/Queue.java) | Circular FIFO Queue | $O(1)$ enqueue/dequeue | Head/rear pointer modulo circular queue. |
| **Trees** | [BinarySearchTree.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/dsa/trees/BinarySearchTree.java) | Binary Search Tree | $O(\log N)$ (avg) search/insert | Insertion, value lookup, DFS traversals (inorder, preorder, postorder). |
| **Graphs** | [Graph.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/dsa/graphs/Graph.java) | Network Adjacency | $O(V + E)$ traversals | Graph adjacency lists representation, BFS and DFS traversals. |
| **Searching**| [BinarySearch.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/dsa/searching/BinarySearch.java) | Binary Search | $O(\log N)$ lookup | Iterative vs. recursive lookups on sorted arrays. |
| **Sorting** | [SortingAlgorithms.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/dsa/sorting/SortingAlgorithms.java) | Sorting Routines | Variable sorting speeds | Bubble Sort, Selection Sort, Insertion Sort ($O(N^2)$), Merge Sort ($O(N \log N)$), and Quick Sort. |

---

### 3. 🎯 Curated LeetCode Exercises (`leetcode/`)

Optimized solutions to standard coding interview questions:

*   **[TwoSum.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/TwoSum.java) (LeetCode 1 - Easy)**
    *   *Technique:* Single-pass `HashMap` lookup.
    *   *Complexity:* $O(N)$ Time | $O(N)$ Space.
*   **[ValidAnagram.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/ValidAnagram.java) (LeetCode 242 - Easy)**
    *   *Technique:* Bucket hash frequency array mapping.
    *   *Complexity:* $O(N)$ Time | $O(1)$ Space.
*   **[ValidParentheses.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/ValidParentheses.java) (LeetCode 20 - Easy)**
    *   *Technique:* LIFO stack matching.
    *   *Complexity:* $O(N)$ Time | $O(N)$ Space.
*   **[ReverseList.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/ReverseList.java) (LeetCode 206 - Easy)**
    *   *Technique:* Pointer swapping (iterative) vs call-stack recursion.
    *   *Complexity:* $O(N)$ Time | $O(1)$ Space (Iterative).
*   **[InvertBinaryTree.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/InvertBinaryTree.java) (LeetCode 226 - Easy)**
    *   *Technique:* DFS recursive swap.
    *   *Complexity:* $O(N)$ Time | $O(H)$ Call-stack Space.
*   **[ClimbingStairs.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/ClimbingStairs.java) (LeetCode 70 - Easy)**
    *   *Technique:* Space-optimized Dynamic Programming.
    *   *Complexity:* $O(N)$ Time | $O(1)$ Space.

---

## 🛠️ Compilation & Execution

Verify implementations locally by compiling and executing the test headers:

```bash
# 1. Compile all source files
javac dsa/linear/*.java dsa/trees/*.java dsa/graphs/*.java dsa/searching/*.java dsa/sorting/*.java leetcode/*.java

# 2. Run Queue test suite
java dsa.linear.Queue

# 3. Run Binary Search Tree suite
java dsa.trees.BinarySearchTree

# 4. Run Sorting Algorithms suite
java dsa.sorting.SortingAlgorithms

# 5. Run Graph traversals suite
java dsa.graphs.Graph

# 6. Run LeetCode Invert Tree suite
java leetcode.InvertBinaryTree
```
