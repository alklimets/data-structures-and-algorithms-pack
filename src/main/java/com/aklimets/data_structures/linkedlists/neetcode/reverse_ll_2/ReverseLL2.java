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

        return left > 1 ? head : prev;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode start = dummy;
        ListNode beginEnd = null;
        for (int i = 0; i < left; i++) {
            beginEnd = start;
            start = start.next;
        }

        ListNode prev = start;
        for (int i = left; i <= right; i++) {
            prev = prev.next;
        }


        for (int i = left; i <= right; i++) {
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        beginEnd.next = prev;

        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseLL2 list = new ReverseLL2();
        ListNode head = new ListNode(1);
        ListNode copy = head;
        for (int i = 2; i <= 5; i++) {
            copy.next = new ListNode(i);
            copy = copy.next;
        }

        ListNode node = list.reverseBetween2(head, 2, 4);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
