package linked_lists;

/**
 * 21. Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 *
 * ====================================================================================================
 *
 * CHAIN OF THOUGHT:
 * 1. We have two sorted linked lists, and we want to merge them into a single
 * sorted linked list.
 * 2. Since both lists are already sorted, we can iterate through both of them
 * simultaneously.
 * 3. We can maintain a pointer for each list (let's say l1 and l2) and compare
 * their values.
 * 4. We'll need a new head for our merged list. To simplify edge cases (like
 * initializing the head),
 * we can use a "dummy" node. The real result will start at dummy.next.
 * 5. In each step of the loop:
 * - Compare l1.val and l2.val.
 * - If l1.val is smaller, attach l1 to our merged list and move l1 forward.
 * - If l2.val is smaller (or equal), attach l2 to our merged list and move l2
 * forward.
 * - Move the tail of our merged list forward.
 * 6. Once one of the lists is exhausted (becomes null), we simply attach the
 * remainder of the other list
 * to the end of our merged list (since the rest is already sorted).
 * 7. Finally, return dummy.next.
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(n + m)
 * We iterate through both lists exactly once, where n and m are the lengths of
 * the two lists.
 * - Space Complexity: O(1)
 * We are only using a few pointers (dummy, tail, l1, l2) and not allocating any
 * new nodes (in-place merge).
 * This is more efficient than the recursive approach which uses O(n + m) stack
 * space.
 *
 * ====================================================================================================
 */

public class MergeTwoSortedLists_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the start of the merged list.
        // This simplifies the code by avoiding special checks for the head of the new
        // list.
        ListNode dummy = new ListNode(-1);

        // 'tail' will always point to the last node in our merged list.
        ListNode tail = dummy;

        // Iterate while both lists have nodes remaining.
        while (list1 != null && list2 != null) {
            // Compare the values of the current nodes in both lists.
            if (list1.val <= list2.val) {
                // If list1's value is smaller or equal, append it to the tail.
                tail.next = list1;
                // Move list1 pointer forward.
                list1 = list1.next;
            } else {
                // If list2's value is smaller, append it to the tail.
                tail.next = list2;
                // Move list2 pointer forward.
                list2 = list2.next;
            }
            // Move the tail pointer forward to the newly added node.
            tail = tail.next;
        }

        // At this point, one of the lists is null.
        // Attach the remaining part of the non-null list to the end of the merged list.
        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }

        // Return the next node of dummy, which is the actual head of the merged list.
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists_21 solution = new MergeTwoSortedLists_21();

        // Test Case 1
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println("Test Case 1:");
        System.out.print("List 1: ");
        printList(list1);
        System.out.print("List 2: ");
        printList(list2);
        ListNode merged1 = solution.mergeTwoLists(list1, list2);
        System.out.print("Merged: ");
        printList(merged1); // Expected: 1 1 2 3 4 4
        System.out.println("--------------------------------------------------");

        // Test Case 2 (Empty lists)
        ListNode list3 = null;
        ListNode list4 = null;
        System.out.println("Test Case 2:");
        System.out.print("List 1: ");
        printList(list3);
        System.out.print("List 2: ");
        printList(list4);
        ListNode merged2 = solution.mergeTwoLists(list3, list4);
        System.out.print("Merged: ");
        printList(merged2); // Expected: (empty)
        System.out.println("--------------------------------------------------");

        // Test Case 3 (One empty)
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        System.out.println("Test Case 3:");
        System.out.print("List 1: ");
        printList(list5);
        System.out.print("List 2: ");
        printList(list6);
        ListNode merged3 = solution.mergeTwoLists(list5, list6);
        System.out.print("Merged: ");
        printList(merged3); // Expected: 0
        System.out.println("--------------------------------------------------");
    }

    // Helper method to print the list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
