package com.aklimets.data_structures.linkedlists.neetcode.copy_with_random_pointer;


import java.util.HashMap;
import java.util.Map;

public class CopyWithRandomPointer {

    /*
        You are given the head of a linked list of length n. Unlike a singly linked list, each node contains an additional pointer random, which may point to any node in the list, or null.
        Create a deep copy of the list.
        The deep copy should consist of exactly n new nodes, each including:
        The original value val of the copied node
        A next pointer to the new node corresponding to the next pointer of the original node
        A random pointer to the new node corresponding to the random pointer of the original node
        Note: None of the pointers in the new list should point to nodes in the original list.
        Return the head of the copied linked list.
        In the examples, the linked list is represented as a list of n nodes. Each node is represented as a pair of [val, random_index] where random_index is the index of the node (0-indexed) that the random pointer points to, or null if it does not point to any node.
        Example 1:
        Input: head = [[3,null],[7,3],[4,0],[5,1]]
        Output: [[3,null],[7,3],[4,0],[5,1]]

        Example 2:
        Input: head = [[1,null],[2,2],[3,2]]
        Output: [[1,null],[2,2],[3,2]]

        Constraints:

        0 <= n <= 100
        -100 <= Node.val <= 100
        random is null or is pointing to some node in the linked list.
    */

    static class RandomNode {
        int val;
        RandomNode next;
        RandomNode random;

        public RandomNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public RandomNode copyRandomList(RandomNode head) {
        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode dummy = new RandomNode(-1);
        RandomNode copy = head;
        RandomNode dummyCopy = dummy;
        while (copy != null) {
            dummyCopy.next = new RandomNode(copy.val);
            dummyCopy = dummyCopy.next;
            map.put(copy, dummyCopy);
            copy = copy.next;
        }

        copy = head;
        dummyCopy = dummy.next;
        while (copy != null) {
            if (copy.random != null) {
                dummyCopy.random = map.get(copy.random);
            }
            dummyCopy = dummyCopy.next;
            copy = copy.next;
        }

        return dummy.next;
    }

    public RandomNode copyRandomList2(RandomNode head) {
        if (head == null) return null;
        RandomNode copy = head;

        while (copy != null) {
            RandomNode newRandomNode = new RandomNode(copy.val);
            newRandomNode.next = copy.next;
            copy.next = newRandomNode;
            copy = newRandomNode.next;
        }

        copy = head;
        while (copy != null) {
            if (copy.random != null) {
                copy.next.random = copy.random.next;
            }
            copy = copy.next.next;
        }

        RandomNode result = head.next;
        RandomNode headCopy = head;
        RandomNode resultCopy = result;
        while (resultCopy != null) {
            headCopy.next = resultCopy.next;
            headCopy = headCopy.next;
            if (headCopy != null) {
                resultCopy.next = headCopy.next;
                resultCopy = resultCopy.next;
            } else {
                resultCopy = null;
            }

        }
        return result;
    }
}
