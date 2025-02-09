package com.aklimets.data_structures.stacks.leetcode.max_freq_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FreqStack {

    /*
        Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
        Implement the FreqStack class:

        FreqStack() constructs an empty frequency stack.
        void push(int val) pushes an integer val onto the top of the stack.
        int pop() removes and returns the most frequent element in the stack.
        If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.

        Example 1:

        Input
        ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
        [[], [5], [7], [5], [7], [4], [5], [], [], [], []]
        Output
        [null, null, null, null, null, null, null, 5, 7, 5, 4]

        Explanation
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].

        Constraints:

        0 <= val <= 10^9
        At most 2 * 10^4 calls will be made to push and pop.
        It is guaranteed that there will be at least one element in the stack before calling pop.
    */

    static int counter = 0;

    static class Node {
        int val;
        Node next;
        Node prev;
    }

    static class QueueNode {
        int val;
        int freq;
        int order;
        Node ref;
    }

    Node head;


    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<QueueNode> maxHeap = new PriorityQueue<>((a, b) -> {
        if (a.freq == b.freq) {
            return b.order - a.order;
        }
        return b.freq - a.freq;
    });

    public FreqStack() {
        head = new Node();
    }

    public void push(int val) {
        Node node = new Node();
        node.prev = head;
        node.next = head.next;
        head.next = node;

        map.compute(val, (key, value) -> value == null ? 1 : value + 1);
        QueueNode qNode = new QueueNode();
        qNode.freq = map.get(val);
        qNode.val = val;
        qNode.ref = node;
        qNode.order = ++counter;

        maxHeap.offer(qNode);
    }

    public int pop() {
        QueueNode qNode = maxHeap.poll();
        map.compute(qNode.val, (key, value) -> value - 1);

        Node node = qNode.ref;
        node.prev.next = node.next;
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        return qNode.val;

    }
}
