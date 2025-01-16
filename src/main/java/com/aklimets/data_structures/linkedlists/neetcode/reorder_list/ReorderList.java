package com.aklimets.data_structures.linkedlists.neetcode.reorder_list;

import com.aklimets.data_structures.linkedlists.neetcode.ListNode;

public class ReorderList {

    /*
        You are given the head of a singly linked-list.
        The positions of a linked list of length = 7 for example, can intially be represented as:
        [0, 1, 2, 3, 4, 5, 6]

        Reorder the nodes of the linked list to be in the following order:
        [0, 6, 1, 5, 2, 4, 3]

        Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:
        [0, n-1, 1, n-2, 2, n-3, ...]

        You may not modify the values in the list's nodes, but instead you must reorder the nodes themselves.

        Example 1:
        Input: head = [2,4,6,8]
        Output: [2,8,4,6]

        Example 2:
        Input: head = [2,4,6,8,10]
        Output: [2,10,4,8,6]

        Constraints:
        1 <= Length of the list <= 1000.
        1 <= Node.val <= 1000
    */

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode current = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode original = head;
        ListNode reverse = prev;
        while (reverse != null) {
            ListNode copy = reverse;
            reverse = reverse.next;

            copy.next = original.next;
            original.next = copy;
            original = original.next.next;
        }


    }
}
