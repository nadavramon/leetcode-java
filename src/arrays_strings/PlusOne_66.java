package arrays_strings;

import java.util.Arrays;

/**
 * 66. Plus One
 *
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to the least significant in
 * left-to-right order.
 * The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 *
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 *
 * Example 3:
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 *
 * ====================================================================================================
 *
 * CHAIN OF THOUGHT:
 * 1. We need to add 1 to the number represented by the array.
 * 2. We should start from the last digit (least significant) and move
 * backwards.
 * 3. If the current digit is less than 9, we can simply increment it and return
 * the array immediately. No carry-over is needed.
 * 4. If the current digit is 9, it becomes 0, and we continue to the next digit
 * (carry-over).
 * 5. If we finish the loop and haven't returned, it means all digits were 9s
 * (e.g., 999 -> 1000).
 * 6. In this case, we need a new array with size + 1. The first digit will be
 * 1, and the rest will be 0 (default value).
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(N)
 * Where N is the number of digits. In the worst case (all 9s), we traverse the
 * entire array.
 * - Space Complexity: O(N)
 * In the worst case (all 9s), we create a new array of size N+1. In other
 * cases, O(1) auxiliary space if we modify in place.
 *
 * ====================================================================================================
 */

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If we are here, it means all digits were 9, so we need a new array
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        PlusOne_66 solution = new PlusOne_66();

        // Test Case 1
        int[] digits1 = { 1, 2, 3 };
        System.out.println("Test Case 1: digits=[1,2,3]");
        System.out.println("Output: " + Arrays.toString(solution.plusOne(digits1))); // Expected: [1,2,4]
        System.out.println("--------------------------------------------------");

        // Test Case 2
        int[] digits2 = { 4, 3, 2, 1 };
        System.out.println("Test Case 2: digits=[4,3,2,1]");
        System.out.println("Output: " + Arrays.toString(solution.plusOne(digits2))); // Expected: [4,3,2,2]
        System.out.println("--------------------------------------------------");

        // Test Case 3
        int[] digits3 = { 9 };
        System.out.println("Test Case 3: digits=[9]");
        System.out.println("Output: " + Arrays.toString(solution.plusOne(digits3))); // Expected: [1,0]
        System.out.println("--------------------------------------------------");

        // Test Case 4
        int[] digits4 = { 9, 9, 9 };
        System.out.println("Test Case 4: digits=[9,9,9]");
        System.out.println("Output: " + Arrays.toString(solution.plusOne(digits4))); // Expected: [1,0,0,0]
        System.out.println("--------------------------------------------------");
    }
}
