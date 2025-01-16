package com.aklimets.data_structures.linkedlists.neetcode.merge_two_sorted_lists;

import com.aklimets.data_structures.linkedlists.neetcode.ListNode;

public class MergeTwoSortedLists {

    /*
        Merge Two Sorted Linked Lists
        You are given the heads of two sorted linked lists list1 and list2.
        Merge the two lists into one sorted linked list and return the head of the new sorted linked list.

        The new list should be made up of nodes from list1 and list2.

        Example 1:
        Input: list1 = [1,2,4], list2 = [1,3,5]

        Output: [1,1,2,3,4,5]
        Example 2:

        Input: list1 = [], list2 = [1,2]

        Output: [1,2]
        Example 3:

        Input: list1 = [], list2 = []

        Output: []
        Constraints:

        0 <= The length of the each list <= 100.
        -100 <= Node.val <= 100
    */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode next = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                next.next = list1;
                list1 = list1.next;
            } else {
                next.next = list2;
                list2 = list2.next;
            }
            next = next.next;
        }
        if (list1 != null) {
            next.next = list1;
        } else {
            next.next = list2;
        }
        return dummy.next;

    }
}
