package com.aklimets.data_structures.linkedlists.neetcode.reverse_in_k_groups;

import com.aklimets.data_structures.linkedlists.neetcode.ListNode;

public class ReverseInKGroups {

    /*
        You are given the head of a singly linked list head and a positive integer k.
        You must reverse the first k nodes in the linked list, and then reverse the next k nodes, and so on. If there are fewer than k nodes left, leave the nodes as they are.
        Return the modified list after reversing the nodes in each group of k.
        You are only allowed to modify the nodes' next pointers, not the values of the nodes.

        Example 1:
        Input: head = [1,2,3,4,5,6], k = 3
        Output: [3,2,1,6,5,4]

        Example 2:
        Input: head = [1,2,3,4,5], k = 3
        Output: [3,2,1,4,5]

        Constraints:

        The length of the linked list is n.
        1 <= k <= n <= 100
        0 <= Node.val <= 100
    */

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode checker = head;
        ListNode end = dummy;
        while (true) {
            ListNode current = checker;
            ListNode endCopy = checker;
            int steps = 0;
            for (int i = 0; i < k; i++) {
                if (checker != null) {
                    checker = checker.next;
                    steps++;
                }
            }

            if (steps < k) {
                break;
            }

            ListNode prev = checker;
            for (int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            end.next = prev;
            end = endCopy;


        }
        return dummy.next;
    }
}
