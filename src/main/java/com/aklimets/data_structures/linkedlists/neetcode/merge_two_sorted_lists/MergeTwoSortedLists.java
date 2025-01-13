package com.aklimets.data_structures.linkedlists.neetcode.merge_two_sorted_lists;

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

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 != null && list2 == null) {
            return list1;
        }
        if (list2 != null && list1 == null) {
            return list2;
        }
        ListNode copy1;
        ListNode copy2;
        ListNode res;
        if (list1.val < list2.val) {
            res = list1;
            copy1 = list1;
            copy2 = list2;
        } else {
            res = list2;
            copy1 = list2;
            copy2 = list1;
        }

        while (copy1.next != null && copy2 != null) {
            if (copy2.val < copy1.next.val) {
                ListNode copy = copy2.next;
                copy2.next = copy1.next;
                copy1.next = copy2;
                copy2 = copy;
                copy1 = copy1.next;
            } else {
                copy1 = copy1.next;
            }
        }
        if (copy1.next == null) {
            copy1.next = copy2;
        }
        return res;

    }
}
