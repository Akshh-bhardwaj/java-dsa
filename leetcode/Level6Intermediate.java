package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Level6Intermediate {

    // 41. Pascal's Triangle (#118)
    // Time Complexity: O(N^2) | Space Complexity: O(N^2) (storage size)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) return triangle;
        
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            row.add(1); // First element is always 1

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1); // Last element is always 1
            triangle.add(row);
        }
        return triangle;
    }

    // 42. Pascal's Triangle II (#119)
    // Time Complexity: O(K) row calculations | Space Complexity: O(K) (storage row only)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            // Calculate element combinations on the fly
            // val_j = val_{j-1} * (n - j + 1) / j
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }
        return row;
    }

    // 43. Happy Number (#202) - Floyd's Cycle-Finding Algorithm (Two Pointers)
    // Time Complexity: O(log N) | Space Complexity: O(1)
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNextNumber(n);
        while (fast != 1 && slow != fast) {
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));
        }
        return fast == 1;
    }

    private int getNextNumber(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    // 44. Missing Number (#268) - Math formula method (Gauss)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

    // 45. Move Zeroes (#283)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 46. Rotate Array (#189) - Reverse mapping method
    // Time Complexity: O(N) | Space Complexity: O(1)
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    // 47. Third Maximum Number (#414)
    // Time Complexity: O(N) | Space Complexity: O(1) (Set limited to size 3)
    public int thirdMax(int[] nums) {
        HashSet<Integer> maxSet = new HashSet<>();
        for (int num : nums) {
            maxSet.add(num);
            if (maxSet.size() > 3) {
                int minVal = Integer.MAX_VALUE;
                for (int val : maxSet) {
                    minVal = Math.min(minVal, val);
                }
                maxSet.remove(minVal);
            }
        }
        if (maxSet.size() < 3) {
            int maxVal = Integer.MIN_VALUE;
            for (int val : maxSet) {
                maxVal = Math.max(maxVal, val);
            }
            return maxVal;
        }
        int minVal = Integer.MAX_VALUE;
        for (int val : maxSet) {
            minVal = Math.min(minVal, val);
        }
        return minVal;
    }

    // 48. Find All Numbers Disappeared in Array (#448) - In-place index negation
    // Time Complexity: O(N) | Space Complexity: O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;
    }

    // 49. Valid Mountain Array (#941)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        // Climb up
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        // Peak can't be first or last
        if (i == 0 || i == n - 1) return false;
        // Climb down
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == n - 1;
    }

    // 50. Monotonic Array (#896)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) increasing = false;
            if (nums[i] < nums[i + 1]) decreasing = false;
        }
        return increasing || decreasing;
    }

    public static void main(String[] args) {
        Level6Intermediate suite = new Level6Intermediate();
        System.out.println("--- Level 6 Intermediate Tests ---");
        System.out.println("Pascal(3): " + suite.generate(3));
        System.out.println("IsHappy(19): " + suite.isHappy(19)); // true
        System.out.println("MissingNumber([3,0,1]): " + suite.missingNumber(new int[]{3, 0, 1})); // 2
    }
}
