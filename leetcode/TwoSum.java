package leetcode;

import java.util.HashMap;
import java.util.Arrays;

/**
 * LeetCode 1: Two Sum
 * Difficulty: Easy
 * 
 * Problem Statement:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * 
 * Time Complexity: O(N) - Linear search using HashMap.
 * Space Complexity: O(N) - Storing items inside the HashMap.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Map to store values and their corresponding indices
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If the complement exists in the map, we found the pair
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Put current element and its index into the map
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution exists");
    }

    public static void main(String[] args) {
        System.out.println("--- LeetCode 1: Two Sum ---");
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("Output indices: " + Arrays.toString(result)); // Expected: [0, 1]
    }
}
