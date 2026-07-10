package leetcode;

/**
 * LeetCode 242: Valid Anagram
 * Difficulty: Easy
 * 
 * Problem Statement:
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * 
 * Time Complexity: O(N) - Single pass through both strings.
 * Space Complexity: O(1) - Constant auxiliary space (26 entries for lower-case English alphabet).
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        // Different lengths cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Standard 26-element array bucket for lowercase characters
        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        // If any value in the array bucket is non-zero, strings are not anagrams
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("--- LeetCode 242: Valid Anagram ---");
        String s = "anagram";
        String t = "nagaram";
        System.out.println("Is \"" + t + "\" an anagram of \"" + s + "\"? " + isAnagram(s, t)); // Expected: true

        String s2 = "rat";
        String t2 = "car";
        System.out.println("Is \"" + t2 + "\" an anagram of \"" + s2 + "\"? " + isAnagram(s2, t2)); // Expected: false
    }
}
