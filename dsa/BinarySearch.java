package dsa;

public class BinarySearch {

    // Iterative Binary Search implementation
    // Assumes array is sorted in ascending order
    public static int searchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoids potential overflow compared to (left + right) / 2

            if (arr[mid] == target) {
                return mid; // Target found
            }
            if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Target not found
    }

    // Recursive Binary Search implementation helper
    public static int searchRecursive(int[] arr, int target) {
        return searchRecursiveHelper(arr, target, 0, arr.length - 1);
    }

    private static int searchRecursiveHelper(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Base case: target not found
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] < target) {
            return searchRecursiveHelper(arr, target, mid + 1, right);
        } else {
            return searchRecursiveHelper(arr, target, left, mid - 1);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("--- Binary Search Test ---");
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;

        int iterativeResult = searchIterative(sortedArray, target);
        int recursiveResult = searchRecursive(sortedArray, target);

        System.out.println("Searching for: " + target);
        System.out.println("Iterative index result: " + iterativeResult); // Expected: 5
        System.out.println("Recursive index result: " + recursiveResult); // Expected: 5

        int missingTarget = 50;
        System.out.println("Searching for missing: " + missingTarget);
        System.out.println("Index result: " + searchIterative(sortedArray, missingTarget)); // Expected: -1
    }
}
