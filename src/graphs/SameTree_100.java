/**
 * 100. Same Tree
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 *
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 * Constraints:
 * The number of nodes in both trees is in the range [0, 100].
 * -10^4 <= Node.val <= 10^4
 *
 * ====================================================================================================
 *
 * CHAIN OF THOUGHT:
 * 1. We need to determine if two binary trees are identical.
 * 2. Identical means:
 *    - They have the same structure (shape).
 *    - The values at corresponding nodes are equal.
 * 3. This naturally suggests a recursive approach (Depth First Search).
 * 4. Base cases:
 *    - If both p and q are null, they are identical (return true).
 *    - If one is null and the other is not, they are different (return false).
 *    - If the values of the current nodes p.val and q.val are different, they are different (return false).
 * 5. Recursive step:
 *    - If the current nodes match, we recursively check if:
 *      - The left subtree of p is the same as the left subtree of q.
 *      - AND the right subtree of p is the same as the right subtree of q.
 * 6. If all these checks pass, the trees are the same.
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(N)
 *   We visit each node in the trees exactly once, where N is the minimum number of nodes in the two trees.
 * - Space Complexity: O(H)
 *   O(H) for the recursion stack, where H is the height of the tree.
 *   In the worst case (skewed tree), H = N, so O(N).
 *   In the best case (balanced tree), H = log N.
 *
 * ====================================================================================================
 */

package graphs;

public class SameTree_100 {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base Case 1: Both nodes are null -> They are identical at this position.
        if (p == null && q == null) {
            return true;
        }

        // Base Case 2: One is null and the other is not -> Structure mismatch.
        if (p == null || q == null) {
            return false;
        }

        // Base Case 3: Values are different -> Value mismatch.
        if (p.val != q.val) {
            return false;
        }

        // Recursive Step: Check if left subtrees are same AND right subtrees are same.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree_100 solution = new SameTree_100();

        // Example 1: p = [1,2,3], q = [1,2,3]
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Test Case 1: p=[1,2,3], q=[1,2,3]");
        System.out.println("Output: " + solution.isSameTree(p1, q1)); // Expected: true
        System.out.println("--------------------------------------------------");

        // Example 2: p = [1,2], q = [1,null,2]
        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("Test Case 2: p=[1,2], q=[1,null,2]");
        System.out.println("Output: " + solution.isSameTree(p2, q2)); // Expected: false
        System.out.println("--------------------------------------------------");

        // Example 3: p = [1,2,1], q = [1,1,2]
        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println("Test Case 3: p=[1,2,1], q=[1,1,2]");
        System.out.println("Output: " + solution.isSameTree(p3, q3)); // Expected: false
        System.out.println("--------------------------------------------------");
    }
}
