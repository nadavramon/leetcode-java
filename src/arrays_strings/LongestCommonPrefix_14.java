package arrays_strings;

/**
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters if it is non-empty.
 *
 * ====================================================================================================
 *
 * CHAIN OF THOUGHT:
 * 1. We need to find the common prefix shared by ALL strings in the array.
 * 2. A simple approach is to take the first string as the initial "common
 * prefix".
 * 3. Then, iterate through the rest of the strings one by one.
 * 4. For each string, check if it starts with the current "common prefix".
 * 5. If it doesn't, shorten the "common prefix" by removing the last character
 * until it matches or becomes empty.
 * 6. If at any point the "common prefix" becomes empty, we can stop and return
 * "" immediately.
 * 7. After checking all strings, the remaining "common prefix" is the answer.
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(S)
 * Where S is the sum of all characters in all strings. In the worst case, we
 * might compare every character of every string.
 * - Space Complexity: O(1)
 * We only use a few variables for storage, and we modify the prefix in place
 * (or reassign the reference).
 * (Note: Java Strings are immutable, so technically we create new string
 * objects during substring, but we don't use auxiliary data structures
 * proportional to input size).
 *
 * ====================================================================================================
 */

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String commonPrefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(commonPrefix) != 0) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
                if (commonPrefix.isEmpty()) {
                    return "";
                }
            }
        }

        return commonPrefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix_14 solution = new LongestCommonPrefix_14();

        // Test Case 1
        String[] strs1 = { "flower", "flow", "flight" };
        System.out.println("Test Case 1: strs=[\"flower\", \"flow\", \"flight\"]");
        System.out.println("Output: \"" + solution.longestCommonPrefix(strs1) + "\""); // Expected: "fl"
        System.out.println("--------------------------------------------------");

        // Test Case 2
        String[] strs2 = { "dog", "racecar", "car" };
        System.out.println("Test Case 2: strs=[\"dog\", \"racecar\", \"car\"]");
        System.out.println("Output: \"" + solution.longestCommonPrefix(strs2) + "\""); // Expected: ""
        System.out.println("--------------------------------------------------");

        // Test Case 3
        String[] strs3 = { "ab", "a" };
        System.out.println("Test Case 3: strs=[\"ab\", \"a\"]");
        System.out.println("Output: \"" + solution.longestCommonPrefix(strs3) + "\""); // Expected: "a"
        System.out.println("--------------------------------------------------");
    }
}
