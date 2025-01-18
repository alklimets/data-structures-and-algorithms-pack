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
        int num1 = 0;
        int num2 = 0;

        ListNode l1copy = l1;
        ListNode l2copy = l2;

        int num1multiplicator = 1;
        int num2multiplicator = 1;
        while (l1copy != null) {
            num1 += l1copy.val * num1multiplicator;
            num1multiplicator *= 10;
            l1copy = l1copy.next;
        }
        while (l2copy != null) {
            num2 += l2copy.val * num2multiplicator;
            num2multiplicator *= 10;
            l2copy = l2copy.next;
        }

        int sum = num1 + num2;
        ListNode head = new ListNode(-1);
        ListNode copy = head;
        if (sum == 0) return new ListNode(0);
        while (sum != 0) {
            int num = sum % 10;
            copy.next = new ListNode(num);
            copy = copy.next;
            sum /= 10;
        }
        return head.next;
    }
}
