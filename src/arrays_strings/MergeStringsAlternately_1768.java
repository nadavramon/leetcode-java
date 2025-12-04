package arrays_strings;

/**
 * 1768. Merge Strings Alternately
 *
 * You are given two strings word1 and word2.
 * Merge the strings by adding letters in alternating order, starting with
 * word1.
 * If a string is longer than the other, append the additional letters onto the
 * end of the merged string.
 * Return the merged string.
 *
 * Example 1:
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1: a b c
 * word2: p q r
 * merged: a p b q c r
 *
 * Example 2:
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1: a b
 * word2: p q r s
 * merged: a p b q r s
 *
 * Example 3:
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1: a b c d
 * word2: p q
 * merged: a p b q c d
 *
 * Constraints:
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 *
 * ====================================================================================================
 *
 * CHAIN OF THOUGHT:
 * 1. We need to iterate through both strings simultaneously.
 * 2. We can use two pointers (or a single index) to track our position in
 * 'word1' and 'word2'.
 * 3. In each iteration, we append a character from 'word1' (if available) and
 * then a character from 'word2' (if available).
 * 4. We continue this until we have processed the full length of the longer
 * string.
 * 5. A StringBuilder is efficient for constructing the result string.
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(M + N)
 * Where M is the length of word1 and N is the length of word2. We process each
 * character exactly once.
 * - Space Complexity: O(1)
 * Excluding the space for the result string (which is O(M+N)), we only use a
 * few integer variables.
 *
 * ====================================================================================================
 */

public class MergeStringsAlternately_1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int n1 = word1.length();
        int n2 = word2.length();

        // Iterate as long as there are characters in either string
        while (i < n1 || i < n2) {
            // Append from word1 if valid
            if (i < n1) {
                result.append(word1.charAt(i));
            }
            // Append from word2 if valid
            if (i < n2) {
                result.append(word2.charAt(i));
            }
            i++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately_1768 solution = new MergeStringsAlternately_1768();

        // Test Case 1
        String w1_1 = "abc";
        String w2_1 = "pqr";
        System.out.println("Test Case 1: word1=\"abc\", word2=\"pqr\"");
        System.out.println("Output: \"" + solution.mergeAlternately(w1_1, w2_1) + "\""); // Expected: "apbqcr"
        System.out.println("--------------------------------------------------");

        // Test Case 2
        String w1_2 = "ab";
        String w2_2 = "pqrs";
        System.out.println("Test Case 2: word1=\"ab\", word2=\"pqrs\"");
        System.out.println("Output: \"" + solution.mergeAlternately(w1_2, w2_2) + "\""); // Expected: "apbqrs"
        System.out.println("--------------------------------------------------");

        // Test Case 3
        String w1_3 = "abcd";
        String w2_3 = "pq";
        System.out.println("Test Case 3: word1=\"abcd\", word2=\"pq\"");
        System.out.println("Output: \"" + solution.mergeAlternately(w1_3, w2_3) + "\""); // Expected: "apbqcd"
        System.out.println("--------------------------------------------------");
    }
}