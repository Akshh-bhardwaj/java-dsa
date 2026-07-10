package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardChallenges {

    // 51. Longest Palindromic Substring (#5)
    // Time Complexity: O(N^2) | Space Complexity: O(1)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);     // Odd palindromes
            int len2 = expandAroundCenter(s, i, i + 1); // Even palindromes
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // 52. Zigzag Conversion (#6)
    // Time Complexity: O(N) | Space Complexity: O(N)
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    // 53. String to Integer (atoi) (#8)
    // Time Complexity: O(N) | Space Complexity: O(1)
    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;
        if (s.length() == 0) return 0;

        // 1. Remove spaces
        while (index < s.length() && s.charAt(index) == ' ') index++;
        if (index == s.length()) return 0;

        // 2. Get sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // 3. Convert numbers and check overflow
        while (index < s.length()) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }

    // 54. Container With Most Water (#11) - Two Pointers
    // Time Complexity: O(N) | Space Complexity: O(1)
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return maxarea;
    }

    // 55. 3Sum (#15) - Sorting + Two Pointers
    // Time Complexity: O(N^2) | Space Complexity: O(log N) (sorting space)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        }
        return res;
    }

    private void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                lo++;
            } else if (sum > 0) {
                hi--;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
            }
        }
    }

    // 56. Generate Parentheses (#22) - Backtracking
    // Time Complexity: O(4^N / sqrt(N)) (Catalan number) | Space Complexity: O(N) (call stack)
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrackParentheses(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrackParentheses(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrackParentheses(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrackParentheses(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    // 57. Letter Combinations of a Phone Number (#17) - Backtracking
    // Time Complexity: O(4^N * N) | Space Complexity: O(N) (call stack)
    private static final String[] PHONE_MAP = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) return combinations;
        backtrackLetterComb(combinations, digits, new StringBuilder(), 0);
        return combinations;
    }

    private void backtrackLetterComb(List<String> combinations, String digits, StringBuilder path, int index) {
        if (path.length() == digits.length()) {
            combinations.add(path.toString());
            return;
        }
        String possibleLetters = PHONE_MAP[digits.charAt(index) - '0'];
        for (char letter : possibleLetters.toCharArray()) {
            path.append(letter);
            backtrackLetterComb(combinations, digits, path, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    // 58. Permutations (#46) - Backtracking
    // Time Complexity: O(N * N!) | Space Complexity: O(N) (call stack)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrackPermute(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrackPermute(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // Element already exists, skip
                tempList.add(nums[i]);
                backtrackPermute(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // 59. Combination Sum (#39) - Backtracking
    // Time Complexity: O(2^T) where T is target | Space Complexity: O(Target/MinElement)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackCombination(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrackCombination(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrackCombination(list, tempList, candidates, remain - candidates[i], i); // reusable, so not i+1
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // 60. Sudoku Solver (#37) - Backtracking
    // Time Complexity: O(9^(M)) where M is number of empty spaces | Space Complexity: O(1)
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidSudokuPlacement(board, i, j, c)) {
                            board[i][j] = c;
                            if (solveSudokuHelper(board)) return true;
                            else board[i][j] = '.'; // Backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSudokuPlacement(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row, col and sub-grid
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        HardChallenges suite = new HardChallenges();
        System.out.println("--- Hard Challenges Tests ---");
        System.out.println("LongestPalindrome(babad): " + suite.longestPalindrome("babad"));
        System.out.println("MaxArea([1,8,6,2,5,4,8,3,7]): " + suite.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println("LetterComb(23): " + suite.letterCombinations("23"));
    }
}
