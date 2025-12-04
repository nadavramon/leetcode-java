package arrays_strings;

/**
 * 392. Is Subsequence
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original
 * string by
 * deleting some (can be none) of the characters without disturbing the relative
 * positions
 * of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 * Constraints:
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * s and t consist only of lowercase English letters.
 *
 * ====================================================================================================
 *
 * CHAIN OF THOUGHT:
 * 1. We need to check if all characters of 's' appear in 't' in the same order.
 * 2. We can use a two-pointer approach:
 * - Pointer 'i' for string 's'.
 * - Pointer 'j' for string 't'.
 * 3. Iterate through 't' using 'j':
 * - If s.charAt(i) matches t.charAt(j), it means we found the current character
 * of 's'.
 * - Move 'i' to the next character to look for.
 * 4. If 'i' reaches s.length(), it means we found all characters of 's' in 't'.
 * Return true.
 * 5. If 'j' reaches t.length() and 'i' hasn't reached s.length(), return false.
 * 6. Edge case: If 's' is empty, it is a subsequence of any string (including
 * empty 't'). Return true.
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(T)
 * We traverse string 't' at most once, where T is the length of 't'.
 * - Space Complexity: O(1)
 * We use only two integer variables for pointers, so the space usage is
 * constant.
 *
 * ====================================================================================================
 */

public class IsSubsequence_392 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;

        int i = 0; // Pointer for s
        int j = 0; // Pointer for t

        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == s.length()) {
                    return true;
                }
            }
            j++;
        }

        return false;
    }

    public static void main(String[] args) {
        IsSubsequence_392 solution = new IsSubsequence_392();

        // Test Case 1
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println("Test Case 1: s=\"" + s1 + "\", t=\"" + t1 + "\"");
        System.out.println("Output: " + solution.isSubsequence(s1, t1)); // Expected: true
        System.out.println("--------------------------------------------------");

        // Test Case 2
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println("Test Case 2: s=\"" + s2 + "\", t=\"" + t2 + "\"");
        System.out.println("Output: " + solution.isSubsequence(s2, t2)); // Expected: false
        System.out.println("--------------------------------------------------");

        // Test Case 3 (Empty s)
        String s3 = "";
        String t3 = "ahbgdc";
        System.out.println("Test Case 3: s=\"" + s3 + "\", t=\"" + t3 + "\"");
        System.out.println("Output: " + solution.isSubsequence(s3, t3)); // Expected: true
        System.out.println("--------------------------------------------------");
    }
}