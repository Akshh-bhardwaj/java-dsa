package leetcode;

public class Level5Recursion {

    // 36. Fibonacci Number (#509)
    // Time Complexity: O(2^N) (pure recursive), O(N) (iterative/memoized)
    // We demonstrate both. The primary method is recursive as requested by category.
    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    // 37. Power of Two (#231)
    // Time Complexity: O(log N) (recursive) | Space Complexity: O(log N)
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    // 38. Climbing Stairs (#70)
    // Time Complexity: O(N) | Space Complexity: O(N) (call stack)
    // We implement it using a memoized recursive approach (Top-Down DP)
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    private int climbStairsMemo(int n, int[] memo) {
        if (n <= 2) return n;
        if (memo[n] > 0) return memo[n];
        memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        return memo[n];
    }

    // 39. Pow(x, n) (#50) - Binary Exponentiation (Recursive)
    // Time Complexity: O(log N) | Space Complexity: O(log N)
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    // 40. Recursive Binary Search (Not tagged separately)
    // Time Complexity: O(log N) | Space Complexity: O(log N) (call stack)
    public int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    private int searchHelper(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) {
            return searchHelper(nums, target, mid + 1, right);
        }
        return searchHelper(nums, target, left, mid - 1);
    }

    public static void main(String[] args) {
        Level5Recursion suite = new Level5Recursion();
        System.out.println("--- Level 5 Recursion Tests ---");
        System.out.println("Fib(6): " + suite.fib(6)); // 8
        System.out.println("IsPowerOfTwo(16): " + suite.isPowerOfTwo(16)); // true
        System.out.println("IsPowerOfTwo(18): " + suite.isPowerOfTwo(18)); // false
        System.out.println("MyPow(2, 10): " + suite.myPow(2.0, 10)); // 1024.0
    }
}
