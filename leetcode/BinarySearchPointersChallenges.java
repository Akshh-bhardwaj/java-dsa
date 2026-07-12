package leetcode;

import java.util.Arrays;

public class BinarySearchPointersChallenges {

    // 80. Remove Duplicates from Sorted Array II
    // Approach 1: Two Pointers - O(N) Time | O(1) Space
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    // 153. Find Minimum in Rotated Sorted Array
    // Approach 1: Binary Search - O(log N) Time | O(1) Space
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1; // Minimum must be in the right unsorted part
            } else {
                right = mid;    // Minimum must be at mid or in left sorted part
            }
        }
        return nums[left];
    }

    // 162. Find Peak Element
    // Approach 1: Binary Search - O(log N) Time | O(1) Space
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;    // Peak is in the left half including mid
            } else {
                left = mid + 1; // Peak is in the right half excluding mid
            }
        }
        return left;
    }

    // 540. Single Element in a Sorted Array
    // Approach 1: Binary Search on odd/even indices - O(log N) Time | O(1) Space
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // Force mid to be even
            if (mid % 2 == 1) mid--;
            
            // If the element is paired with its next element, single element is on the right
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    // 74. Search a 2D Matrix
    // Approach 1: Binary Search treating matrix as 1D array - O(log(M*N)) Time | O(1) Space
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / n][mid % n];
            if (midElement == target) return true;
            if (midElement < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    // 240. Search a 2D Matrix II
    // Approach 1: Search Space Reduction (starting top-right) - O(M + N) Time | O(1) Space
    public boolean searchMatrixII(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] < target) {
                row++; // Move down
            } else {
                col--; // Move left
            }
        }
        return false;
    }

    // 378. Kth Smallest Element in a Sorted Matrix
    // Approach 1: Binary Search on value ranges - O((M + N) * log(Max-Min)) Time | O(1) Space
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countLessEqual(int[][] matrix, int mid) {
        int n = matrix.length;
        int count = 0;
        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += row + 1; // All elements above in this column are also <= mid
                col++;
            } else {
                row--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BinarySearchPointersChallenges suite = new BinarySearchPointersChallenges();
        System.out.println("--- Binary Search & Pointers Challenges Tests ---");
        int[] rotateArr = {3, 4, 5, 1, 2};
        System.out.println("Min in Rotated array: " + suite.findMin(rotateArr)); // 1
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        System.out.println("SearchMatrix(3): " + suite.searchMatrix(matrix, 3)); // true
    }
}
