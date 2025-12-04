/**
 * 67. Add Binary
 *
 * You are given two binary strings a and b, return their sum as a binary string.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Constraints:
 * 1 <= a.length, b.length <= 10^4
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 *
 * ====================================================================================================
 *
 * CHAIN OF THOUGHT:
 * 1. We need to add two binary numbers represented as strings.
 * 2. This is similar to adding two decimal numbers, but we carry over when the sum is 2 or more (since it's base 2).
 * 3. We should process the strings from right to left (from the least significant bit to the most significant).
 * 4. We can use two pointers, i and j, starting at the end of strings a and b respectively.
 * 5. We also need a 'carry' variable to keep track of the carry-over from the previous position.
 * 6. In each iteration:
 *    - Get the digit from a at index i (if i >= 0), otherwise 0.
 *    - Get the digit from b at index j (if j >= 0), otherwise 0.
 *    - Calculate sum = digitA + digitB + carry.
 *    - The new digit to append is sum % 2.
 *    - The new carry is sum / 2.
 * 7. We append the result digits to a StringBuilder. Since we are processing from right to left, the result will be reversed.
 * 8. Finally, if there is a remaining carry, append it.
 * 9. Reverse the StringBuilder and return the string.
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(max(N, M))
 *   We iterate through the longer of the two strings once. N and M are lengths of strings a and b.
 * - Space Complexity: O(max(N, M))
 *   We use a StringBuilder to store the result, which will be at most max(N, M) + 1 characters long.
 *
 * ====================================================================================================
 */

package arrays_strings;

public class AddBinary_67 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        // Iterate as long as there are digits in a or b, or there is a carry remaining.
        // Note: The original code had `while (i >= 0 || j >= 0)`, but we should also
        // check `carry > 0` inside or after.
        // The user's code handled carry after the loop, which is also fine.
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char to int
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert char to int
            }
            sb.append(sum % 2); // Append the result bit (0 or 1)
            carry = sum / 2; // Calculate the new carry (0 or 1)
            i--;
            j--;
        }

        // If there is a remaining carry after processing both strings, append it.
        if (carry > 0) {
            sb.append(carry);
        }

        // Reverse the string builder to get the correct order.
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary_67 solution = new AddBinary_67();

        // Test Case 1
        String a1 = "11";
        String b1 = "1";
        System.out.println("Test Case 1: a = \"" + a1 + "\", b = \"" + b1 + "\"");
        System.out.println("Output: " + solution.addBinary(a1, b1)); // Expected: "100"
        System.out.println("--------------------------------------------------");

        // Test Case 2
        String a2 = "1010";
        String b2 = "1011";
        System.out.println("Test Case 2: a = \"" + a2 + "\", b = \"" + b2 + "\"");
        System.out.println("Output: " + solution.addBinary(a2, b2)); // Expected: "10101"
        System.out.println("--------------------------------------------------");

        // Test Case 3 (Carry overflow)
        String a3 = "111";
        String b3 = "111";
        System.out.println("Test Case 3: a = \"" + a3 + "\", b = \"" + b3 + "\"");
        System.out.println("Output: " + solution.addBinary(a3, b3)); // Expected: "1110"
        System.out.println("--------------------------------------------------");
    }
}
