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
├── java_demos/              # ☕ Executable Java Concept Demos
│   ├── oop/
│   │   └── OOPDemo.java     # OOP Principles
│   ├── collections/
│   │   └── CollectionsDemo.java # List, Set, Map & PriorityQueue
│   ├── exceptions/
│   │   └── ExceptionsDemo.java # Exception Handling & Custom errors
│   ├── io/
│   │   └── IODemo.java     # Buffered File Readers/Writers
│   └── concurrency/
│       └── ConcurrencyDemo.java # Spawning Threads, Sync & Pools
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
└── leetcode/                # 🎯 Curated LeetCode Solutions (60 Problems)
    ├── Level1Beginner.java  # Problems 1-10 (Absolute Beginner)
    ├── Level2Arrays.java    # Problems 11-20 (Array basics)
    ├── Level3Strings.java   # Problems 21-30 (String operations)
    ├── Level4Searching.java  # Problems 31-35 (Binary search variations)
    ├── Level5Recursion.java  # Problems 36-40 (Backtracking/Recursion basics)
    ├── Level6Intermediate.java # Problems 41-50 (Intermediate DP/Arrays)
    └── HardChallenges.java  # Problems 51-60 (Advanced Backtracking/Math)
```

---

## 📚 Curriculum Index

### 1. 📝 Full Java Reference Guides & Executable Demos (`notes/` & `java_demos/`)

Detailed cheatsheets paired with corresponding runnable examples:

| Module | Core Concept Guide | Runnable Code Implementation | Concepts Demonstrated |
| :--- | :--- | :--- | :--- |
| **01** | **[Language Basics](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/notes/java-cheatsheet.md)** | Included in Cheat Sheet | Variables, Input scanning, Operators, Type casting, Arrays. |
| **02** | **[OOP Principles](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/notes/02_java_oop.md)** | **[OOPDemo.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/java_demos/oop/OOPDemo.java)** | Interface execution, encapsulation accessors, polymorphism overrides, abstraction abstract classes. |
| **03** | **[Collections Framework](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/notes/03_java_collections.md)** | **[CollectionsDemo.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/java_demos/collections/CollectionsDemo.java)** | `ArrayList` indexing, `HashSet` duplicate filtering, `HashMap` keys, `PriorityQueue` Min-Heap polls. |
| **04** | **[Exceptions & I/O](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/notes/04_java_exceptions_io.md)** | **[ExceptionsDemo.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/java_demos/exceptions/ExceptionsDemo.java)**, **[IODemo.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/java_demos/io/IODemo.java)** | Try-catch-finally, checked exceptions vs. runtimes, custom error throwing, `BufferedReader`/`FileWriter`. |
| **05** | **[Multithreading](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/notes/05_java_multithreading.md)** | **[ConcurrencyDemo.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/java_demos/concurrency/ConcurrencyDemo.java)** | Thread/Runnable runs, concurrent monitor synchronization locks, `ExecutorService` fixed thread pooling. |

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

### 3. 🎯 Curated LeetCode Solutions Index (60 Problems)

Solutions are grouped logically into compilation classes inside the `leetcode/` directory:

#### 🟢 [Level 1: Absolute Beginner](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/Level1Beginner.java) (Problems 1–10)
*   **1. Fizz Buzz (#412)** $\rightarrow$ Conditional loops
*   **2. Palindrome Number (#9)** $\rightarrow$ Math reversion
*   **3. Steps to Reduce to Zero (#1342)** $\rightarrow$ Bit checks / conditionals
*   **4. Richest Customer Wealth (#1672)** $\rightarrow$ 2D array row sum
*   **5. Running Sum of 1D Array (#1480)** $\rightarrow$ Prefix cumulative array sums
*   **6. Even Number of Digits (#1295)** $\rightarrow$ Int digit string conversion
*   **7. Shuffle the Array (#1470)** $\rightarrow$ Sub-array interleaving
*   **8. Concatenation of Array (#1929)** $\rightarrow$ Array doubling copies
*   **9. Build Array from Permutation (#1920)** $\rightarrow$ In-place math representation
*   **10. Kids With Greatest Candies (#1431)** $\rightarrow$ Iterative comparisons

#### 🟢 [Level 2: Arrays](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/Level2Arrays.java) (Problems 11–20)
*   **11. Two Sum (#1)** $\rightarrow$ HashMap lookups ($O(N)$ Time)
*   **12. Best Time to Buy & Sell Stock (#121)** $\rightarrow$ Single-pass minimum tracker
*   **13. Remove Duplicates (#26)** $\rightarrow$ Two-pointer in-place unique compaction
*   **14. Remove Element (#27)** $\rightarrow$ Two-pointer shifting
*   **15. Maximum Subarray (#53)** $\rightarrow$ Kadane's dynamic prefix sum
*   **16. Plus One (#66)** $\rightarrow$ Carry math array updates
*   **17. Merge Sorted Array (#88)** $\rightarrow$ Three-pointer reverse insertion
*   **18. Contains Duplicate (#217)** $\rightarrow$ HashSet frequency tracking
*   **19. Majority Element (#169)** $\rightarrow$ Boyer-Moore voting threshold
*   **20. Find Pivot Index (#724)** $\rightarrow$ Left/Right cumulative equilibrium

#### 🟡 [Level 3: Strings](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/Level3Strings.java) (Problems 21–30)
*   **21. Valid Anagram (#242)** $\rightarrow$ Hashed frequency buckets
*   **22. Reverse String (#344)** $\rightarrow$ Two-pointer buffer swaps
*   **23. Reverse Words in a String III (#557)** $\rightarrow$ Character space checks
*   **24. Length of Last Word (#58)** $\rightarrow$ Reverse spacer scanning
*   **25. Longest Common Prefix (#14)** $\rightarrow$ Iterative horizontal slicing
*   **26. Roman to Integer (#13)** $\rightarrow$ Subtraction Roman character states
*   **27. Valid Palindrome (#125)** $\rightarrow$ Two-pointer character normalization
*   **28. First Unique Character (#387)** $\rightarrow$ Double-pass bucket frequencies
*   **29. Reverse Vowels of a String (#345)** $\rightarrow$ Two-pointer vowel swaps
*   **30. Add Binary (#67)** $\rightarrow$ Reverse string carry calculations

#### 🟡 [Level 4: Searching](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/Level4Searching.java) (Problems 31–35)
*   **31. Binary Search (#704)** $\rightarrow$ Iterative pivot splits ($O(\log N)$)
*   **32. Search Insert Position (#35)** $\rightarrow$ Insert lower-bound range mapping
*   **33. Guess Number Higher/Lower (#374)** $\rightarrow$ Binary search range guess checks
*   **34. Square Root(x) (#69)** $\rightarrow$ Binary search integer midpoints
*   **35. First Bad Version (#278)** $\rightarrow$ Binary boundary search division

#### 🟠 [Level 5: Recursion](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/Level5Recursion.java) (Problems 36–40)
*   **36. Fibonacci Number (#509)** $\rightarrow$ Pure recursive relations
*   **37. Power of Two (#231)** $\rightarrow$ Recursive divide-by-two bases
*   **38. Climbing Stairs (#70)** $\rightarrow$ Memoized top-down recursion
*   **39. Pow(x, n) (#50)** $\rightarrow$ Binary recursive exponentiation
*   **40. Recursive Binary Search** $\rightarrow$ Recursive range splits

#### 🟠 [Level 6: Intermediate](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/Level6Intermediate.java) (Problems 41–50)
*   **41. Pascal's Triangle (#118)** $\rightarrow$ Dynamic array list generation
*   **42. Pascal's Triangle II (#119)** $\rightarrow$ Single-row combination shifts
*   **43. Happy Number (#202)** $\rightarrow$ Floyd's cycle-finding pointers
*   **44. Missing Number (#268)** $\rightarrow$ Gauss math formula sum ($O(1)$ Space)
*   **45. Move Zeroes (#283)** $\rightarrow$ Double pointer index shifting
*   **46. Rotate Array (#189)** $\rightarrow$ Reverse array segment mapping
*   **47. Third Maximum Number (#414)** $\rightarrow$ Size-restricted hash collection
*   **48. Disappeared Numbers (#448)** $\rightarrow$ In-place index sign negation
*   **49. Valid Mountain Array (#941)** $\rightarrow$ Up-down pointer check climbs
*   **50. Monotonic Array (#896)** $\rightarrow$ Sorted direction flag comparisons

#### 🔴 [Hard Challenges](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/HardChallenges.java) (Problems 51–60)
*   **51. Longest Palindromic Substring (#5)** $\rightarrow$ Expand around center check ($O(N^2)$)
*   **52. Zigzag Conversion (#6)** $\rightarrow$ Multi-row StringBuilder mapping
*   **53. String to Integer atoi (#8)** $\rightarrow$ Sign/Whitespace/Integer overflow validation
*   **54. Container With Most Water (#11)** $\rightarrow$ Two-pointer area compaction
*   **55. 3Sum (#15)** $\rightarrow$ Sorted array + two-pointer search
*   **56. Generate Parentheses (#22)** $\rightarrow$ Backtracking open/close checks
*   **57. Letter Combinations of Phone Number (#17)** $\rightarrow$ Backtracking phone matrix digits
*   **58. Permutations (#46)** $\rightarrow$ Backtracking permutations list swapping
*   **59. Combination Sum (#39)** $\rightarrow$ Backtracking element candidates sum
*   **60. Sudoku Solver (#37)** $\rightarrow$ Grid checking backtracking

---

## 🛠️ Compilation & Execution

Verify implementations locally by compiling and executing the test suites:

```bash
# 1. Compile all source files
javac java_demos/**/*.java dsa/linear/*.java dsa/trees/*.java dsa/graphs/*.java dsa/searching/*.java dsa/sorting/*.java leetcode/*.java

# 2. Run Java OOP Demo (single-file execution)
java java_demos/oop/OOPDemo.java

# 3. Run Java Concurrency Demo (single-file execution)
java java_demos/concurrency/ConcurrencyDemo.java
```
