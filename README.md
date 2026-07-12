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
└── leetcode/                # 🎯 Curated LeetCode Solutions (97 Problems)
    ├── Level1Beginner.java  # Problems 1-10 (Absolute Beginner)
    ├── Level2Arrays.java    # Problems 11-20 (Array basics)
    ├── Level3Strings.java   # Problems 21-30 (String operations)
    ├── Level4Searching.java  # Problems 31-35 (Binary search variations)
    ├── Level5Recursion.java  # Problems 36-40 (Backtracking/Recursion basics)
    ├── Level6Intermediate.java # Problems 41-50 (Intermediate DP/Arrays)
    ├── HardChallenges.java  # Problems 51-60 (Advanced Backtracking/Math)
    # --- Advanced Topic Groups (37 Problems) ---
    ├── IntervalChallenges.java # Problems 61-67 (Interval merges & boundaries)
    ├── StackSimulationChallenges.java # Problems 68-79 (Advanced Stack, Queues & Scheduling)
    ├── StringParsingChallenges.java # Problems 80-84 (Regex, equation parsing, masking)
    ├── BinarySearchPointersChallenges.java # Problems 85-91 (Matrix searches & dynamic pointers)
    └── MatrixSimulationChallenges.java # Problems 92-97 (Diagonal traverses, Game of Life, spiral matrices)
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

### 3. 🎯 Curated LeetCode Solutions Index (97 Problems)

Solutions are grouped logically into compilation classes inside the `leetcode/` directory:

#### 🟢 [Level 1: Absolute Beginner](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/Level1Beginner.java) (Problems 1–10)
*   **1. Fizz Buzz (#412)**
*   **2. Palindrome Number (#9)**
*   **3. Steps to Reduce to Zero (#1342)**
*   **4. Richest Customer Wealth (#1672)**
*   **5. Running Sum of 1D Array (#1480)**
*   **6. Even Number of Digits (#1295)**
*   **7. Shuffle the Array (#1470)**
*   **8. Concatenation of Array (#1929)**
*   **9. Build Array from Permutation (#1920)**
*   **10. Kids With Greatest Candies (#1431)**

#### 🟢 [Level 2: Arrays](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/Level2Arrays.java) (Problems 11–20)
*   **11. Two Sum (#1)**
*   **12. Best Time to Buy & Sell Stock (#121)**
*   **13. Remove Duplicates (#26)**
*   **14. Remove Element (#27)**
*   **15. Maximum Subarray (#53)**
*   **16. Plus One (#66)**
*   **17. Merge Sorted Array (#88)**
*   **18. Contains Duplicate (#217)**
*   **19. Majority Element (#169)**
*   **20. Find Pivot Index (#724)**

#### 🟡 [Level 3: Strings](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/Level3Strings.java) (Problems 21–30)
*   **21. Valid Anagram (#242)**
*   **22. Reverse String (#344)**
*   **23. Reverse Words in a String III (#557)**
*   **24. Length of Last Word (#58)**
*   **25. Longest Common Prefix (#14)**
*   **26. Roman to Integer (#13)**
*   **27. Valid Palindrome (#125)**
*   **28. First Unique Character (#387)**
*   **29. Reverse Vowels of a String (#345)**
*   **30. Add Binary (#67)**

#### 🟡 [Level 4: Searching](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/Level4Searching.java) (Problems 31–35)
*   **31. Binary Search (#704)**
*   **32. Search Insert Position (#35)**
*   **33. Guess Number Higher/Lower (#374)**
*   **34. Square Root(x) (#69)**
*   **35. First Bad Version (#278)**

#### 🟠 [Level 5: Recursion](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/Level5Recursion.java) (Problems 36–40)
*   **36. Fibonacci Number (#509)**
*   **37. Power of Two (#231)**
*   **38. Climbing Stairs (#70)**
*   **39. Pow(x, n) (#50)**
*   **40. Recursive Binary Search**

#### 🟠 [Level 6: Intermediate](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/Level6Intermediate.java) (Problems 41–50)
*   **41. Pascal's Triangle (#118)**
*   **42. Pascal's Triangle II (#119)**
*   **43. Happy Number (#202)**
*   **44. Missing Number (#268)**
*   **45. Move Zeroes (#283)**
*   **46. Rotate Array (#189)**
*   **47. Third Maximum Number (#414)**
*   **48. Disappeared Numbers (#448)**
*   **49. Valid Mountain Array (#941)**
*   **50. Monotonic Array (#896)**

#### 🔴 [Hard Challenges](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/HardChallenges.java) (Problems 51–60)
*   **51. Longest Palindromic Substring (#5)**
*   **52. Zigzag Conversion (#6)**
*   **53. String to Integer atoi (#8)**
*   **54. Container With Most Water (#11)**
*   **55. 3Sum (#15)**
*   **56. Generate Parentheses (#22)**
*   **57. Letter Combinations of Phone Number (#17)**
*   **58. Permutations (#46)**
*   **59. Combination Sum (#39)**
*   **60. Sudoku Solver (#37)**

#### 🪐 [Interval Challenges](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/IntervalChallenges.java) (Problems 61–67)
*   **61. Insert Interval (#57)** $\rightarrow$ Linear scans & merging
*   **62. Merge Intervals (#56)** $\rightarrow$ Sort by start bounds
*   **63. Non-overlapping Intervals (#435)** $\rightarrow$ Greedy removal counts
*   **64. Interval List Intersections (#986)** $\rightarrow$ Dual-pointer intervals scan
*   **65. Missing Ranges (#163)** $\rightarrow$ Single pass margin checks
*   **66. Summary Ranges (#228)** $\rightarrow$ Sliding contiguous trackers
*   **67. Min Balloon Burst Arrows (#452)** $\rightarrow$ Sorting end points greedy shots

#### 🪐 [Stack & Simulation Challenges](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/StackSimulationChallenges.java) (Problems 68–79)
*   **68. Find K Closest Elements (#658)** $\rightarrow$ Binary search range pointers
*   **69. Reveal Cards Increasing (#950)** $\rightarrow$ Queue indices simulation
*   **70. Task Scheduler (#621)** $\rightarrow$ Math frequency slots calculation
*   **71. Simplify Path (#71)** $\rightarrow$ Split/Deque path normalization
*   **72. Longest Absolute File Path (#388)** $\rightarrow$ Deep array tab index tracking
*   **73. Exclusive Time of Functions (#636)** $\rightarrow$ ID stack bounds timer
*   **74. Asteroid Collision (#735)** $\rightarrow$ Collision logic stack pops
*   **75. Validate Stack Sequences (#946)** $\rightarrow$ Greedy simulation index push/pop
*   **76. Remove Adjacent Duplicates II (#1209)** $\rightarrow$ Frequency stack char sweeps
*   **77. Reverse Parentheses Substrings (#1190)** $\rightarrow$ Parentheses index stack swaps
*   **78. Decode String (#394)** $\rightarrow$ Dual stacks (digits & strings) parsing
*   **79. Min Parentheses Removes (#1249)** $\rightarrow$ Index stack filter invalid chars

#### 🪐 [String Parsing Challenges](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/StringParsingChallenges.java) (Problems 80–84)
*   **80. Compare Version Numbers (#165)** $\rightarrow$ Dual-pointer numeric dot splits
*   **81. Validate IP Address (#468)** $\rightarrow$ IPv4 vs. IPv6 custom syntax parsing
*   **82. Masking Personal Information (#831)** $\rightarrow$ Email/Phone sub-format masks
*   **83. Remove Comments (#722)** $\rightarrow$ Single-line / block state machine filters
*   **84. Solve the Equation (#640)** $\rightarrow$ Left/Right side parsing reduction

#### 🪐 [Binary Search & Pointers Challenges](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/BinarySearchPointersChallenges.java) (Problems 85–91)
*   **85. Remove Duplicates II (#80)** $\rightarrow$ Two-pointer boundary array compaction
*   **86. Find Min in Rotated Array (#153)** $\rightarrow$ Pivot range binary search
*   **87. Find Peak Element (#162)** $\rightarrow$ Range pivot peak checks binary search
*   **88. Single Element Sorted Array (#540)** $\rightarrow$ Even/Odd index pair binary search
*   **89. Search 2D Matrix (#74)** $\rightarrow$ Standard 1D-mapped binary search
*   **90. Search 2D Matrix II (#240)** $\rightarrow$ Corner-start range reduction pointers
*   **91. Kth Smallest Sorted Matrix (#378)** $\rightarrow$ Matrix counts binary search range

#### 🪐 [Matrix Simulation Challenges](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/MatrixSimulationChallenges.java) (Problems 92–97)
*   **92. Spiral Matrix II (#59)** $\rightarrow$ 4-direction edge boundary loops
*   **93. Rotate Image (#48)** $\rightarrow$ In-place matrix transpose & row reverses
*   **94. Game of Life (#289)** $\rightarrow$ Bit state transit matrices code mapping
*   **95. Spiral Matrix III (#885)** $\rightarrow$ Step-increase spiral walking checks
*   **96. Diagonal Traverse (#498)** $\rightarrow$ Toggle-direction index diagonals traversing
*   **97. Spiral Matrix (#54)** $\rightarrow$ Linear boundary spiral traversing

---

## 🛠️ Compilation & Execution

Verify implementations locally by compiling and executing the test suites:

```bash
# 1. Compile all source files
javac java_demos/**/*.java dsa/linear/*.java dsa/trees/*.java dsa/graphs/*.java dsa/searching/*.java dsa/sorting/*.java leetcode/*.java

# 2. Run new LeetCode Suites
java leetcode.IntervalChallenges
java leetcode.StackSimulationChallenges
java leetcode.StringParsingChallenges
java leetcode.BinarySearchPointersChallenges
java leetcode.MatrixSimulationChallenges
```
