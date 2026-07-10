package leetcode;

import java.util.Stack;

/**
 * LeetCode 20: Valid Parentheses
 * Difficulty: Easy
 * 
 * Problem Statement:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * 
 * Time Complexity: O(N) - Linear pass through the string.
 * Space Complexity: O(N) - Worst case storing all opening brackets on the stack.
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // Handle closing brackets
            else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // String is valid if stack is completely empty
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("--- LeetCode 20: Valid Parentheses ---");
        String test1 = "()[]{}";
        String test2 = "([)]";
        String test3 = "{[]}";

        System.out.println(test1 + " -> " + isValid(test1)); // Expected: true
        System.out.println(test2 + " -> " + isValid(test2)); // Expected: false
        System.out.println(test3 + " -> " + isValid(test3)); // Expected: true
    }
}
