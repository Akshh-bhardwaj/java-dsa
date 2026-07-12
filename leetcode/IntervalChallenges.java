package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalChallenges {

    // 57. Insert Interval
    // Approach 1: Greedy Linear scan - O(N) Time | O(N) Space
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals ending before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        // Merge overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add remaining intervals
        while (i < n) {
            result.add(intervals[i++]);
        }

        return result.toArray(new int[result.size()][]);
    }

    // 56. Merge Intervals
    // Approach 1: Sorting - O(N log N) Time | O(N) Space
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort by start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for (int[] interval : intervals) {
            int current_end = currentInterval[1];
            int next_start = interval[0];
            int next_end = interval[1];

            if (current_end >= next_start) {
                currentInterval[1] = Math.max(current_end, next_end);
            } else {
                currentInterval = interval;
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    // 435. Non-overlapping Intervals
    // Approach 1: Greedy (by end time) - O(N log N) Time | O(1) Space
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++; // Overlap detected, increment removals
            } else {
                end = intervals[i][1]; // Move boundary
            }
        }
        return count;
    }

    // 986. Interval List Intersections
    // Approach 1: Two Pointers - O(M + N) Time | O(M + N) Space
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            // Find intersection range
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) {
                result.add(new int[]{start, end});
            }

            // Move the pointer of the interval that ends first
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    // 163. Missing Ranges
    // Approach 1: Single Pass - O(N) Time | O(1) Space
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if (n == 0) {
            result.add(Arrays.asList(lower, upper));
            return result;
        }

        // Check range before first element
        if (nums[0] > lower) {
            result.add(Arrays.asList(lower, nums[0] - 1));
        }

        // Check gaps between elements
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] > nums[i] + 1) {
                result.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        // Check range after last element
        if (nums[n - 1] < upper) {
            result.add(Arrays.asList(nums[n - 1] + 1, upper));
        }

        return result;
    }

    // 228. Summary Ranges
    // Approach 1: Linear Scan with sliding pointers - O(N) Time | O(1) Space
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                result.add(String.valueOf(start));
            }
        }
        return result;
    }

    // 452. Minimum Number of Arrows to Burst Balloons
    // Approach 1: Greedy (by end coordinates) - O(N log N) Time | O(1) Space
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort by end coordinate (avoids overflow unlike subtraction)
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int firstEnd = points[0][1];

        for (int[] point : points) {
            int start = point[0];
            int end = point[1];

            // If balloon starts after current arrow range, we need another arrow
            if (start > firstEnd) {
                arrows++;
                firstEnd = end;
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        IntervalChallenges suite = new IntervalChallenges();
        System.out.println("--- Interval Challenges Tests ---");
        int[][] mergeInput = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Merged: " + Arrays.deepToString(suite.merge(mergeInput)));
        int[] summaryInput = {0, 1, 2, 4, 5, 7};
        System.out.println("Summary Ranges: " + suite.summaryRanges(summaryInput));
    }
}
