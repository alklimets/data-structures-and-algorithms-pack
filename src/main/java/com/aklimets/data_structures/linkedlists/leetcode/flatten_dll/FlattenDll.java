package com.aklimets.data_structures.linkedlists.leetcode.flatten_dll;

public class FlattenDll {

    /*
        You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.
        Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.
        Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.

        Example 1:
        Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
        Output: [1,2,3,7,8,11,12,9,10,4,5,6]
        Explanation: The multilevel linked list in the input is shown.
        After flattening the multilevel linked list it becomes:

        Example 2:
        Input: head = [1,2,null,3]
        Output: [1,3,2]
        Explanation: The multilevel linked list in the input is shown.
        After flattening the multilevel linked list it becomes:

        Example 3:
        Input: head = []
        Output: []
        Explanation: There could be empty list in the input.
    */

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if (head == null) return null;
        flat(head);
        return head;
    }

    public Node flat(Node head) {
        if (head == null) return null;
        Node copy = head;
        while (copy != null) {
            Node next = copy.next;
            Node child = flat(copy.child);

            Node tail = child;
            while (tail != null && tail.next != null) {
                tail = tail.next;
            }

            if (child != null) {
                copy.next = child;
                child.prev = copy;
                tail.next = next;
                if (next != null) {
                    next.prev = tail;
                }
            }
            copy.child = null;
            copy = next;
        }
        return head;
    }

    public Node flat2(Node head) {
        if (head == null) return null;
        Node copy = head;
        while (copy != null) {
            Node next = copy.next;
            Node child = flat2(copy.child);
            copy.child = null;
            while (child != null) {
                copy.next = child;
                child.prev = copy;
                child = child.next;
                copy = copy.next;
            }
            copy.next = next;
            if (next != null) {
                next.prev = copy;
            }
            copy = copy.next;
        }
        return head;
    }
}
