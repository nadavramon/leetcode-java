/*
You are given two strings word1 and word2.
Merge the strings by adding letters in alternating order,
starting with word1. If a string is longer than the other,
append the additional letters onto the end of the merged string.
Return the merged string.

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d

Constraints:

1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
 */

class 1768_MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        char[] result = new char[m + n];
        int i = 0, k = 0, j = 0;
        /*
        i - counter for word1 current index.
        j - counter for word2 current index.
        k - counter for the result array current index.
         */

        while (i < m && j < n) {
            result[k] = word1.charAt(i);
            k++;
            i++;
            result[k] = word2.charAt(j);
            k++;
            j++;
        }

        while (i < m) {
            result[k] = word1.charAt(i);
            k++;
            i++;
        }

        while (j < n) {
            result[k] = word2.charAt(j);
            k++;
            j++;
        }
        return new String(result);
    }
}