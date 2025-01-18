package com.aklimets.data_structures.linkedlists.neetcode.merge_k_sorted;

import com.aklimets.data_structures.linkedlists.neetcode.ListNode;

public class MergeKSorted {

    /*
        You are given an array of k linked lists lists, where each list is sorted in ascending order.
        Return the sorted linked list that is the result of merging all of the individual linked lists.
        Example 1:
        Input: lists = [[1,2,4],[1,3,5],[3,6]]
        Output: [1,1,2,3,3,4,5,6]

        Example 2:
        Input: lists = []
        Output: []

        Example 3:
        Input: lists = [[]]
        Output: []

        Constraints:

        0 <= lists.length <= 1000
        0 <= lists[i].length <= 100
        -1000 <= lists[i][j] <= 1000
    */

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode head = new ListNode(-1);
        ListNode copy = head;
        boolean notNulls = true;
        while (notNulls) {
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            boolean nulls = false;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    minIndex = i;
                    min = lists[i].val;
                }
                nulls |= lists[i] != null;
            }
            if (!nulls) break;
            copy.next = new ListNode(lists[minIndex].val);
            copy = copy.next;
            lists[minIndex] = lists[minIndex].next;
            notNulls = nulls;
        }
        return head.next;
    }

}
