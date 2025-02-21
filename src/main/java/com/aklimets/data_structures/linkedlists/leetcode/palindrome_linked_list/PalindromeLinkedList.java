package com.aklimets.data_structures.linkedlists.leetcode.palindrome_linked_list;

import com.aklimets.data_structures.linkedlists.neetcode.ListNode;

public class PalindromeLinkedList {

    /*
        Given the head of a singly linked list, return true if it is a
        palindrome or false otherwise.

        Example 1:

        Input: head = [1,2,2,1]
        Output: true

        Example 2:

        Input: head = [1,2]
        Output: false

        Constraints:

        The number of nodes in the list is in the range [1, 10^5].
        0 <= Node.val <= 9


        Follow up: Could you do it in O(n) time and O(1) space?
    */

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        while (prev != null) {
            if (prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;

    }
}
