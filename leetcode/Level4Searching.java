package leetcode;

public class Level4Searching {

    // 31. Binary Search (#704)
    // Time Complexity: O(log N) | Space Complexity: O(1)
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // 32. Search Insert Position (#35)
    // Time Complexity: O(log N) | Space Complexity: O(1)
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left; // Returns index where it should be inserted
    }

    // 33. Guess Number Higher or Lower (#374)
    // Time Complexity: O(log N) | Space Complexity: O(1)
    private int pick = 6; // Mock pick value
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) return mid;
            else if (res < 0) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    // Mock API for Guess Number (#374)
    private int guess(int num) {
        if (num == pick) return 0;
        return (num > pick) ? -1 : 1;
    }

    // 34. Square Root(x) (#69)
    // Time Complexity: O(log X) | Space Complexity: O(1)
    public int mySqrt(int x) {
        if (x < 2) return x;
        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long) pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }
        return right;
    }

    // 35. First Bad Version (#278)
    // Time Complexity: O(log N) | Space Complexity: O(1)
    private int badVersion = 4; // Mock bad version
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Mock API for First Bad Version (#278)
    private boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public static void main(String[] args) {
        Level4Searching suite = new Level4Searching();
        System.out.println("--- Level 4 Searching Tests ---");
        int[] sorted = {1, 3, 5, 6};
        System.out.println("SearchInsert(5): " + suite.searchInsert(sorted, 5)); // 2
        System.out.println("SearchInsert(2): " + suite.searchInsert(sorted, 2)); // 1
        System.out.println("Sqrt(8): " + suite.mySqrt(8)); // 2
    }
}
