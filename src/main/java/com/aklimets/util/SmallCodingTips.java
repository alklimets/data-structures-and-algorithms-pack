package com.aklimets.util;

import java.util.*;
import java.util.stream.Stream;

public class SmallCodingTips {

    public static void main(String[] args) {
        // convert int[] to List<Integer>
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.stream(arr).boxed().toList();

        // to int[]
        int[] arr2 = list.stream().mapToInt(i -> i).toArray();

        int[] alphabet = new int[26]; // represents english alphabet
        // to access index -> ch - 'a'

        char[] charArr = new char[1];
        String keyFromArray = new String(charArr);
        String keyFromIntArr = Arrays.toString(arr);

        // for palindrome check indexes work faster than substring before them

        // basic java impl of data structures and methods
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.pop();

        Queue<Integer> queue = new LinkedList<>(); // simple queue
        queue.offer(1);
        queue.poll();

        Queue<Integer> heap = new PriorityQueue<>(); // heap
        heap.offer(1);
        heap.poll();

        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addFirst(2);
        deque.removeLast();
        deque.removeFirst();
    }
}
