# ☕ Java & DSA Master Blueprint

Welcome to the **Java & DSA Master Blueprint**! This repository is a comprehensive learning and reference suite designed for developers mastering Java language syntax, core Data Structures and Algorithms (DSA), and standard LeetCode coding interview problems.

> 🚀 **Designed for the Feed:** This repository is structured to document learning progress, highlight clean-code practices, and serve as a complete cheatsheet to share with the developer community.

---

## 📂 Repository Structure

The repository is modularly organized into three core areas:
*   **`notes/`**: Conceptual reference materials, including a complete syntax and methods cheatsheet.
*   **`dsa/`**: Production-grade implementations of fundamental data structures and algorithmic routines.
*   **`leetcode/`**: Solved coding challenges with optimized runtime characteristics and complexity notes.

```text
java-dsa/
├── README.md
├── notes/
│   └── java-cheatsheet.md
├── dsa/
│   ├── SinglyLinkedList.java
│   ├── Stack.java
│   └── BinarySearch.java
└── leetcode/
    ├── TwoSum.java
    ├── ValidParentheses.java
    └── ReverseList.java
```

---

## 📚 Curriculum Index

### 1. [☕ Java Basics Cheatsheet](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/notes/java-cheatsheet.md)
A consolidated, high-density syntax guide containing:
*   **Boilerplate & Output:** Class entry points, printing methods (`print`, `println`, `printf`).
*   **Scanner Input:** Reading keyboard primitives and strings.
*   **Variables & Data Types:** Primitives size/range boundaries and explicit narrowing type casting.
*   **Control Flow & Loops:** Conditionals, Ternary, Switch-case, For, While, and Enhanced For-each loops.
*   **Objects & Functions:** Overloaded signatures, recursive factorials, and standard `String` and `Math` class methods.

---

### 2. [📊 Core Data Structures & Algorithms](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/dsa)

Production-grade Java implementations of fundamental computer science concepts:

| File | Concept | Complexity | Operations / Highlights |
| :--- | :--- | :--- | :--- |
| **[SinglyLinkedList.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/dsa/SinglyLinkedList.java)** | Linked Lists | $O(N)$ insertion/deletion | Single node structures, sequential transversals, element-deletion. |
| **[Stack.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/dsa/Stack.java)** | LIFO Buffers | $O(1)$ push/pop | Stack array representation, Overflow/Underflow error protection. |
| **[BinarySearch.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/dsa/BinarySearch.java)** | Search Efficiency | $O(\log N)$ search | Iterative vs. Recursive implementations on sorted arrays. |

---

### 3. [🎯 Curated LeetCode Exercises](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode)

Optimized solutions to standard interview questions:

*   **[TwoSum.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/TwoSum.java) (LeetCode 1 - Easy)**
    *   *Technique:* Single-pass `HashMap` lookup.
    *   *Complexity:* $O(N)$ Time | $O(N)$ Space.
*   **[ValidParentheses.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/ValidParentheses.java) (LeetCode 20 - Easy)**
    *   *Technique:* Dynamic LIFO stack matching.
    *   *Complexity:* $O(N)$ Time | $O(N)$ Space.
*   **[ReverseList.java](file:///Users/akshit/.gemini/antigravity-ide/scratch/java-dsa/leetcode/ReverseList.java) (LeetCode 206 - Easy)**
    *   *Technique:* Multi-pointer iterative swap & call-stack recursive pointers.
    *   *Complexity:* $O(N)$ Time | $O(1)$ Space (Iterative).

---

## 🛠️ Compilation & Execution

Verify implementations locally by compiling and executing the test headers:

```bash
# 1. Compile all source files
javac dsa/*.java leetcode/*.java

# 2. Run Linked List test suite
java dsa.SinglyLinkedList

# 3. Run Stack test suite
java dsa.Stack

# 4. Run LeetCode TwoSum test suite
java leetcode.TwoSum
```
