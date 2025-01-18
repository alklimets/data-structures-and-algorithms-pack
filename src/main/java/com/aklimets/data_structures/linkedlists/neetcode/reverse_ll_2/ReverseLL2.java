package com.aklimets.data_structures.linkedlists.neetcode.reverse_ll_2;

import com.aklimets.data_structures.linkedlists.neetcode.ListNode;

public class ReverseLL2 {

    /*
        Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
        Example 1:
        Input: head = [1,2,3,4,5], left = 2, right = 4
        Output: [1,4,3,2,5]

        Example 2:
        Input: head = [5], left = 1, right = 1

        Output: [5]

        Constraints:

        The number of nodes in the list is n.
        1 <= n <= 500
        -500 <= Node.val <= 500
        1 <= left <= right <= n
    */

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode before = null;
        ListNode leftNode = head;
        ListNode after = head;
        for (int i = 1; i <= right; i++) {
            if (i < left) {
                before = leftNode;
                leftNode = leftNode.next;
            }
            after = after.next;
        }

        ListNode current = leftNode;
        ListNode prev = after;

        while (current != after) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if (left > 1) {
            before.next = prev;
        }

        return left > 1 ? head :  prev;
    }
}
