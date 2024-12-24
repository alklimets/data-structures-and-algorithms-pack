package com.aklimets.data_structures.linkedlists;

import java.util.Collection;

public class MyLinkedList<T> {

    private int size = 0;

    private static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T value;

        boolean isRoot;

        public Node(T value) {
            this.value = value;
        }

        public Node(boolean isRoot) {
            this.isRoot = isRoot;
        }
    }

    private Node<T> head;

    public MyLinkedList() {
    }

    public MyLinkedList(Collection<T> collection) {
        collection.forEach(this::add);
    }

    public void add(T value) {
        if (head == null) {
            head = new Node<>(true);
            Node<T> node = new Node<>(value);
            head.next = node;
            head.prev = node;
            node.next = head;
            node.prev = head;
        } else {
            Node<T> node = new Node<>(value);
            head.prev.next = node;
            node.prev = head.prev;
            node.next = head;
            head.prev = node;
        }
        size++;
    }

    public T getFirst() {
        if (head == null) return null;
        return head.value;
    }

    public T getLast() {
        if (head == null) return null;
        return head.prev.value;
    }

    public T get(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(String.format("Out of bound: index %d is out of size %d", index, size));
        Node<T> copy = head;
        while (index > 0) {
            copy = copy.next;
            index--;
        }
        return copy.value;
    }

    public void reverse() {
        if (head != null) {
            Node<T> pointer = head.next;
            while (!pointer.isRoot) {
                Node<T> copy = pointer;
                pointer = pointer.next;
                copy.prev.next = copy.next;
                copy.next.prev = copy.prev;

                copy.next = head.next;
                copy.prev = head;
                head.next.prev = copy;
                head.next = copy;
            }
        }
    }


    public void print() {
        if (head != null) {
            Node<T> copy = head.next;
            while (!copy.isRoot) {
                System.out.print(copy.value + " ");
                copy = copy.next;
            }
        }
    }

    public void printReverse() {
        if (head != null) {
            Node<T> copy = head.prev;
            while (!copy.isRoot) {
                System.out.print(copy.value + " ");
                copy = copy.prev;
            }
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        if (size != that.getSize()) return false;

        Node<?> thisCopy = head.next;
        Node<?> thatCopy = that.head.next;
        while (!thisCopy.isRoot) {
            if (!thisCopy.value.equals(thatCopy.value)) return false;
            thisCopy = thisCopy.next;
            thatCopy = thatCopy.next;
        }
        return true;
    }

    // usage examples
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        System.out.println("Initial list:");
        myLinkedList.print();
        System.out.println();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        System.out.println("After add:");
        System.out.print("Print normal: ");
        myLinkedList.print();

        System.out.print("\nPrint reverse: ");
        myLinkedList.printReverse();

        System.out.println("\nSize: " + myLinkedList.getSize());
        System.out.println("First: " + myLinkedList.getFirst());
        System.out.println("Last: " + myLinkedList.getLast());
        System.out.println("Second: " + myLinkedList.get(1));
        System.out.println("Fourth: " + myLinkedList.get(3));
//        System.out.println("Out of bound: " + myLinkedList.get(4));

        myLinkedList.reverse();
        System.out.print("Print normal: ");
        myLinkedList.print();
    }

}
