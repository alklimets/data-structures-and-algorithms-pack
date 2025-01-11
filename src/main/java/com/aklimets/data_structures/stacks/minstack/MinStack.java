package com.aklimets.data_structures.stacks.minstack;

public class MinStack {

    /*
        Minimum Stack
        Design a stack class that supports the push, pop, top, and getMin operations.

        MinStack() initializes the stack object.
        void push(int val) pushes the element val onto the stack.
        void pop() removes the element on the top of the stack.
        int top() gets the top element of the stack.
        int getMin() retrieves the minimum element in the stack.
        Each function should run in O(1) time.

        Example 1:

        Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]

        Output: [null,null,null,null,0,null,2,1]

        Explanation:
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        minStack.getMin(); // return 0
        minStack.pop();
        minStack.top();    // return 2
        minStack.getMin(); // return 1
        Constraints:

        -2^31 <= val <= 2^31 - 1.
        pop, top and getMin will always be called on non-empty stacks.

    */

    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node minStack;

    public MinStack() {

    }

    public void push(int val) {
        head = new Node(val, head);
        if (minStack == null || minStack.value >= val) {
            minStack = new Node(val, minStack);
        }
    }

    public void pop() {
        int value = head.value;
        head = head.next;
        if (minStack.value == value) {
            minStack = minStack.next;
        }
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        if (minStack == null) {
            return 0;
        }
        return minStack.value;
    }
}
