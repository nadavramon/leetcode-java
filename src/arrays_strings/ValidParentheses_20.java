package arrays_strings;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([])"
 * Output: true
 *
 * Constraints:
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 *
 * ====================================================================================================
 *
 * CHAIN OF THOUGHT:
 * 1. This is a classic stack problem.
 * 2. We iterate through the string character by character.
 * 3. If we encounter an opening bracket ('(', '{', '['), we push it onto the
 * stack.
 * 4. If we encounter a closing bracket:
 * - We check if the stack is empty. If it is, it means there's no matching
 * opening bracket, so return false.
 * - We pop the top element from the stack.
 * - We check if the popped element matches the current closing bracket. If not,
 * return false.
 * 5. After iterating through the entire string, the stack must be empty. If
 * it's not, it means there are unclosed opening brackets, so return false.
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(N)
 * We traverse the string once, performing O(1) stack operations for each
 * character.
 * - Space Complexity: O(N)
 * In the worst case (e.g., "((((("), the stack will hold all characters.
 *
 * ====================================================================================================
 */

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(')
                    return false;
                if (c == '}' && top != '{')
                    return false;
                if (c == ']' && top != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses_20 solution = new ValidParentheses_20();

        // Test Case 1
        String s1 = "()";
        System.out.println("Test Case 1: s=\"()\"");
        System.out.println("Output: " + solution.isValid(s1)); // Expected: true
        System.out.println("--------------------------------------------------");

        // Test Case 2
        String s2 = "()[]{}";
        System.out.println("Test Case 2: s=\"()[]{}\"");
        System.out.println("Output: " + solution.isValid(s2)); // Expected: true
        System.out.println("--------------------------------------------------");

        // Test Case 3
        String s3 = "(]";
        System.out.println("Test Case 3: s=\"(]\"");
        System.out.println("Output: " + solution.isValid(s3)); // Expected: false
        System.out.println("--------------------------------------------------");

        // Test Case 4
        String s4 = "([)]";
        System.out.println("Test Case 4: s=\"([)]\"");
        System.out.println("Output: " + solution.isValid(s4)); // Expected: false
        System.out.println("--------------------------------------------------");

        // Test Case 5
        String s5 = "{[]}";
        System.out.println("Test Case 5: s=\"{[]}\"");
        System.out.println("Output: " + solution.isValid(s5)); // Expected: true
        System.out.println("--------------------------------------------------");
    }
}
