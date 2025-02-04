package com.aklimets.data_structures.linkedlists.neetcode.add_two_numbers;

import com.aklimets.data_structures.linkedlists.neetcode.ListNode;

public class AddTwoNumbers {

    /*
        You are given two non-empty linked lists, l1 and l2, where each represents a non-negative integer.
        The digits are stored in reverse order, e.g. the number 123 is represented as 3 -> 2 -> 1 -> in the linked list.
        Each of the nodes contains a single digit. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
        Return the sum of the two numbers as a linked list.

        Example 1:
        Input: l1 = [1,2,3], l2 = [4,5,6]
        Output: [5,7,9]
        Explanation: 321 + 654 = 975.

        Example 2:
        Input: l1 = [9], l2 = [9]
        Output: [8,1]

        Constraints:

        1 <= l1.length, l2.length <= 100.
        0 <= Node.val <= 9
    */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode head = new ListNode(-1);
        ListNode copy = head;
        while (l1 != null || l2 != null) {
            int sum = add;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum >= 10) {
                add = 1;
                sum %= 10;
            } else {
                add = 0;
            }
            ListNode node = new ListNode(sum);
            copy.next = node;
            copy = copy.next;

        }
        if (add == 1) {
            copy.next = new ListNode(1);
        }
        return head.next;
    }
}
