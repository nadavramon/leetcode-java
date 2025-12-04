/**
 * 1. Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * Constraints:
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 *
 * ====================================================================================================
 *
 * CHAIN OF THOUGHT:
 * 1. We need to find two numbers in the array that sum up to a specific 'target'.
 * 2. The brute-force approach would be to check every pair of numbers, which gives us O(n^2) time complexity.
 *    We want to do better than that, ideally O(n).
 * 3. As we iterate through the array, for each number 'num', we are looking for another number 'complement'
 *    such that num + complement = target. This means complement = target - num.
 * 4. If we can check if this 'complement' exists in the array efficiently, we can solve the problem faster.
 * 5. A HashMap is perfect for this. It allows us to store numbers we've seen so far and their indices.
 *    Lookups in a HashMap are O(1) on average.
 * 6. So, the algorithm is:
 *    - Iterate through the array.
 *    - Calculate the complement (target - current_number).
 *    - Check if the complement is already in our HashMap.
 *      - If yes, we found the pair! Return their indices.
 *      - If no, add the current number and its index to the HashMap and continue.
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(n)
 *   We traverse the list containing n elements exactly once. Each lookup in the table costs only O(1) time.
 * - Space Complexity: O(n)
 *   The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
 *
 * ====================================================================================================
 */

package arrays_strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum_1 {

    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the numbers we have seen so far and their indices.
        // Key: the number itself, Value: the index of that number.
        Map<Integer, Integer> numMap = new HashMap<>();

        // Iterate over the array of numbers.
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement that would sum with nums[i] to make the target.
            int complement = target - nums[i];

            // Check if this complement is already in our map (meaning we saw it before).
            if (numMap.containsKey(complement)) {
                // If found, we have our pair.
                // Return the index of the complement (stored in the map) and the current index i.
                return new int[]{numMap.get(complement), i};
            }

            // If the complement is not found, add the current number and its index to the map.
            // This allows future numbers to find this one as their complement.
            numMap.put(nums[i], i);
        }

        // If no solution is found (though the problem statement guarantees one), return an empty array.
        return new int[]{};
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Test Case 1: Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1)); // Expected: [0, 1]
        System.out.println("--------------------------------------------------");

        // Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Test Case 2: Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2)); // Expected: [1, 2]
        System.out.println("--------------------------------------------------");

        // Test Case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Test Case 3: Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(result3)); // Expected: [0, 1]
        System.out.println("--------------------------------------------------");
    }
}