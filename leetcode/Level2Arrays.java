package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Level2Arrays {

    // 11. Two Sum (#1)
    // Time Complexity: O(N) | Space Complexity: O(N)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // 12. Best Time to Buy and Sell Stock (#121)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    // 13. Remove Duplicates from Sorted Array (#26)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    // 14. Remove Element (#27)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    // 15. Maximum Subarray (#53) - Kadane's Algorithm
    // Time Complexity: O(N) | Space Complexity: O(1)
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    // 16. Plus One (#66)
    // Time Complexity: O(N) | Space Complexity: O(N) (only in worst case of all 9s)
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    // 17. Merge Sorted Array (#88)
    // Time Complexity: O(M + N) | Space Complexity: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }

    // 18. Contains Duplicate (#217)
    // Time Complexity: O(N) | Space Complexity: O(N)
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    // 19. Majority Element (#169) - Boyer-Moore Voting Algorithm
    // Time Complexity: O(N) | Space Complexity: O(1)
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    // 20. Find Pivot Index (#724)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Level2Arrays suite = new Level2Arrays();
        System.out.println("--- Level 2 Arrays Tests ---");
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("MaxProfit: " + suite.maxProfit(prices)); // 5
        int[] nums = {1, 1, 2};
        System.out.println("RemoveDuplicates len: " + suite.removeDuplicates(nums)); // 2
    }
}
