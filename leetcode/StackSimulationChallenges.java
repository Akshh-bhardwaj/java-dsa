package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class StackSimulationChallenges {

    // 658. Find K Closest Elements
    // Approach 1: Binary Search & Two Pointers - O(log(N-K) + K) Time | O(1) Space
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;

        // Binary search to find left starting index of closest subarray
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    // 950. Reveal Cards In Increasing Order
    // Approach 1: Queue Simulation - O(N log N) Time | O(N) Space
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> indexQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            indexQueue.add(i);
        }

        int[] result = new int[n];
        for (int card : deck) {
            result[indexQueue.poll()] = card;
            if (!indexQueue.isEmpty()) {
                indexQueue.add(indexQueue.poll()); // Move next index to the back
            }
        }
        return result;
    }

    // 621. Task Scheduler
    // Approach 1: Math frequency calculation - O(N) Time | O(1) Space
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (char t : tasks) {
            frequencies[t - 'A']++;
        }
        Arrays.sort(frequencies);

        int maxFreq = frequencies[25];
        int idleTime = (maxFreq - 1) * n;

        for (int i = 24; i >= 0 && frequencies[i] > 0; i--) {
            idleTime -= Math.min(maxFreq - 1, frequencies[i]);
        }

        idleTime = Math.max(0, idleTime);
        return tasks.length + idleTime;
    }

    // 71. Simplify Path
    // Approach 1: Stack Parsing - O(N) Time | O(N) Space
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] components = path.split("/");

        for (String directory : components) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                stack.addLast(directory);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }

    // 388. Longest Absolute File Path
    // Approach 1: Hash/Array Stack depth representation - O(N) Time | O(D) depth Space
    public int lengthLongestPath(String input) {
        String[] parts = input.split("\n");
        int[] pathLens = new int[parts.length + 1];
        int maxLen = 0;

        for (String s : parts) {
            int depth = s.lastIndexOf("\t") + 1; // Tab count denotes hierarchy depth
            int nameLen = s.length() - depth;

            if (s.contains(".")) { // File detected
                maxLen = Math.max(maxLen, pathLens[depth] + nameLen);
            } else { // Directory detected
                pathLens[depth + 1] = pathLens[depth] + nameLen + 1; // +1 for slash separator
            }
        }
        return maxLen;
    }

    // 636. Exclusive Time of Functions
    // Approach 1: Stack Simulation - O(N) Time | O(N/2) Space
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if (!stack.isEmpty()) {
                result[stack.peek()] += timestamp - prevTime - (type.equals("end") ? 0 : 0);
                if (type.equals("end")) {
                    result[stack.peek()] += 1; // include the boundary time unit
                }
            }

            if (type.equals("start")) {
                stack.push(id);
                prevTime = timestamp;
            } else {
                stack.pop();
                prevTime = timestamp + 1; // start of next time unit
            }
        }
        return result;
    }

    // 735. Asteroid Collision
    // Approach 1: Stack Collision Check - O(N) Time | O(N) Space
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean collision = false;
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                if (stack.peek() < -ast) {
                    stack.pop(); // Asteroid on stack explodes, check next
                    continue;
                } else if (stack.peek() == -ast) {
                    stack.pop(); // Both explode
                }
                collision = true;
                break;
            }
            if (!collision) {
                stack.push(ast);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    // 946. Validate Stack Sequences
    // Approach 1: Greedy Stack Simulation - O(N) Time | O(N) Space
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // Pointer in popped array

        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    // 1209. Remove All Adjacent Duplicates in String II
    // Approach 1: Stack of character counts - O(N) Time | O(N) Space
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> countStack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                countStack.push(1);
            } else {
                int incremented = countStack.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k; // Readjust index
                } else {
                    countStack.push(incremented);
                }
            }
        }
        return sb.toString();
    }

    // 1190. Reverse Substrings Between Each Pair of Parentheses
    // Approach 1: Straightforward stack reversing - O(N^2) Time | O(N) Space
    public String reverseParentheses(String s) {
        Stack<Integer> openBrackets = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openBrackets.push(sb.length());
            } else if (c == ')') {
                int start = openBrackets.pop();
                reverseSubstring(sb, start, sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private void reverseSubstring(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }

    // 394. Decode String
    // Approach 1: Two Stack (Count + String) - O(N) Time | O(N) Space
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder decodedString = stringStack.pop();
                int currentK = countStack.pop();
                for (int i = 0; i < currentK; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }

    // 1249. Minimum Remove to Make Valid Parentheses
    // Approach 1: Stack Index tracking - O(N) Time | O(N) Space
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.push(i);
            } else if (sb.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '*'); // Mark invalid close parentheses
                }
            }
        }

        // Mark remaining unmatched open parentheses
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }

        return sb.toString().replace("*", "");
    }

    public static void main(String[] args) {
        StackSimulationChallenges suite = new StackSimulationChallenges();
        System.out.println("--- Stack & Simulation Challenges Tests ---");
        System.out.println("SimplifyPath(/a/./b/../../c/): " + suite.simplifyPath("/a/./b/../../c/")); // /c
        System.out.println("DecodeString(3[a]2[bc]): " + suite.decodeString("3[a]2[bc]")); // aaabcbc
    }
}
