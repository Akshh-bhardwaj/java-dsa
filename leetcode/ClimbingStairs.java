package leetcode;

/**
 * LeetCode 70: Climbing Stairs
 * Difficulty: Easy
 * 
 * Problem Statement:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Time Complexity: O(N) - Linear iteration.
 * Space Complexity: O(1) - Space-optimized Fibonacci mapping.
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        // Base cases
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    public static void main(String[] args) {
        System.out.println("--- LeetCode 70: Climbing Stairs ---");
        int stairs = 5;
        System.out.println("Number of ways to climb " + stairs + " stairs: " + climbStairs(stairs)); // Expected: 8 (Fibonacci sequence: 1, 2, 3, 5, 8)
    }
}
