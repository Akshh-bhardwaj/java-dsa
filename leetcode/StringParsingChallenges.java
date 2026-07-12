package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringParsingChallenges {

    // 165. Compare Version Numbers
    // Approach 1: Two Pointers String parsing - O(M + N) Time | O(1) Space
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n1 = version1.length(), n2 = version2.length();

        while (i < n1 || j < n2) {
            int num1 = 0;
            while (i < n1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i++) - '0');
            }
            i++; // Skip the dot '.'

            int num2 = 0;
            while (j < n2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j++) - '0');
            }
            j++; // Skip the dot '.'

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }
        return 0;
    }

    // 468. Validate IP Address
    // Approach 1: Manual string validation - O(N) Time | O(1) Space
    public String validIPAddress(String queryIP) {
        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(queryIP);
        } else if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(queryIP);
        }
        return "Neither";
    }

    private String validateIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) return "Neither";
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3) return "Neither";
            if (part.charAt(0) == '0' && part.length() != 1) return "Neither"; // Leading zeros
            int val = 0;
            for (char ch : part.toCharArray()) {
                if (!Character.isDigit(ch)) return "Neither";
                val = val * 10 + (ch - '0');
            }
            if (val > 255) return "Neither";
        }
        return "IPv4";
    }

    private String validateIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) return "Neither";
        String hexDigits = "0123456789abcdefABCDEF";
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) return "Neither";
            for (char ch : part.toCharArray()) {
                if (hexDigits.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }

    // 831. Masking Personal Information
    // Approach 1: Substring categorization - O(N) Time | O(N) Space
    public String maskPII(String s) {
        if (s.contains("@")) { // Email detection
            s = s.toLowerCase();
            int atIndex = s.indexOf("@");
            return s.charAt(0) + "*****" + s.substring(atIndex - 1);
        } else { // Phone number detection
            // Keep only digits
            StringBuilder digits = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    digits.append(ch);
                }
            }
            int n = digits.length();
            String local = "***-***-" + digits.substring(n - 4);
            if (n == 10) return local;
            
            // Handle international codes
            StringBuilder countryCode = new StringBuilder("+");
            for (int i = 0; i < n - 10; i++) countryCode.append("*");
            return countryCode.append("-").append(local).toString();
        }
    }

    // 722. Remove Comments
    // Approach 1: State Machine linear parsing - O(N) Time | O(N) Space
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder currentLine = new StringBuilder();

        for (String line : source) {
            int i = 0;
            char[] chars = line.toCharArray();
            while (i < chars.length) {
                if (!inBlock) {
                    if (i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '*') {
                        inBlock = true;
                        i++;
                    } else if (i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '/') {
                        break; // Skip rest of the line
                    } else {
                        currentLine.append(chars[i]);
                    }
                } else {
                    if (i + 1 < chars.length && chars[i] == '*' && chars[i + 1] == '/') {
                        inBlock = false;
                        i++;
                    }
                }
                i++;
            }
            // End of line, append if not empty and not in middle of block comment
            if (!inBlock && currentLine.length() > 0) {
                result.add(currentLine.toString());
                currentLine.setLength(0); // Reset for next line
            }
        }
        return result;
    }

    // 640. Solve the Equation
    // Approach 1: Equation split parsing - O(N) Time | O(1) Space
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] left = evaluateSide(parts[0]);
        int[] right = evaluateSide(parts[1]);

        int xCount = left[0] - right[0];
        int numCount = right[1] - left[1];

        if (xCount == 0 && numCount == 0) return "Infinite solutions";
        if (xCount == 0) return "No solution";
        return "x=" + (numCount / xCount);
    }

    private int[] evaluateSide(String side) {
        int xCount = 0;
        int numCount = 0;
        int i = 0;
        int sign = 1;
        int n = side.length();

        while (i < n) {
            if (side.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (side.charAt(i) == '-') {
                sign = -1;
                i++;
            }

            int val = 0;
            boolean hasDigit = false;
            while (i < n && Character.isDigit(side.charAt(i))) {
                val = val * 10 + (side.charAt(i) - '0');
                i++;
                hasDigit = true;
            }

            if (i < n && side.charAt(i) == 'x') {
                xCount += sign * (hasDigit ? val : 1);
                i++;
            } else {
                numCount += sign * val;
            }
        }
        return new int[]{xCount, numCount};
    }

    public static void main(String[] args) {
        StringParsingChallenges suite = new StringParsingChallenges();
        System.out.println("--- String Parsing Challenges Tests ---");
        System.out.println("SolveEq(x+5-3+x=6+x-2): " + suite.solveEquation("x+5-3+x=6+x-2")); // x=2
        System.out.println("CompareVersion(1.01, 1.001): " + suite.compareVersion("1.01", "1.001")); // 0
    }
}
