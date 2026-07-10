package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Level1Beginner {

    // 1. Fizz Buzz (#412)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    // 2. Palindrome Number (#9)
    // Time Complexity: O(log10(N)) | Space Complexity: O(1)
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    // 3. Number of Steps to Reduce a Number to Zero (#1342)
    // Time Complexity: O(log N) | Space Complexity: O(1)
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            steps++;
        }
        return steps;
    }

    // 4. Richest Customer Wealth (#1672)
    // Time Complexity: O(M * N) | Space Complexity: O(1)
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] customer : accounts) {
            int currentWealth = 0;
            for (int bank : customer) {
                currentWealth += bank;
            }
            maxWealth = Math.max(maxWealth, currentWealth);
        }
        return maxWealth;
    }

    // 5. Running Sum of 1D Array (#1480)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    // 6. Find Numbers with Even Number of Digits (#1295)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // 7. Shuffle the Array (#1470)
    // Time Complexity: O(N) | Space Complexity: O(N)
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }
        return result;
    }

    // 8. Concatenation of Array (#1929)
    // Time Complexity: O(N) | Space Complexity: O(N)
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    // 9. Build Array from Permutation (#1920)
    // Time Complexity: O(N) | Space Complexity: O(1) (if space optimization mapping used)
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        // In-place mapping using math representation to avoid O(N) space
        // val = a + b * n; element values remain nums[i] % n
        for (int i = 0; i < n; i++) {
            int b = nums[nums[i]] % n;
            nums[i] = nums[i] + b * n;
        }
        for (int i = 0; i < n; i++) {
            nums[i] /= n;
        }
        return nums;
    }

    // 10. Kids With Greatest Number of Candies (#1431)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }
        return result;
    }

    public static void main(String[] args) {
        Level1Beginner suite = new Level1Beginner();
        System.out.println("--- Level 1 Beginner Tests ---");
        System.out.println("FizzBuzz(5): " + suite.fizzBuzz(5));
        System.out.println("IsPalindrome(121): " + suite.isPalindrome(121));
        System.out.println("StepsToZero(14): " + suite.numberOfSteps(14));
    }
}
