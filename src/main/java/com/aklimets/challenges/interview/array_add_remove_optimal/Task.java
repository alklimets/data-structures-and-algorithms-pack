package com.aklimets.challenges.interview.array_add_remove_optimal;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {

    static int counter = 0;

    // BF
    public static List<Integer> processArrayBF(int[] input) {
        List<Integer> result = new ArrayList<>();
        for (int val : input) {
            if (val < 0) {
                result.add(val);
            } else if (val > 0) {
                if (val - 1 < result.size()) {
                    counter++;
                    result.remove(val - 1);
                }
            }
        }
        return result;
    }


    private static class BucketList {

        private int size = 0;
        private int added = 0;

        private final int bucketLimit = 2;

        private LinkedList<List<Integer>> buckets = new LinkedList<>();

        public void add(int value) {
            if (added % bucketLimit == 0) {
                buckets.add(new LinkedList<>());
            }
            List<Integer> bucket = buckets.getLast();
            bucket.add(value);
            size++;
            added++;
        }

        public void remove(int index) {
            if (index <= size) {
                int bucketIndex = 0;
                while (index > buckets.get(bucketIndex).size()) {
                    index -= buckets.get(bucketIndex++).size();
                }
                buckets.get(bucketIndex).remove(index - 1);
                size--;
                counter++;
            }
        }

        public List<Integer> combine() {
            return buckets.stream().flatMap(List::stream).collect(Collectors.toList());
        }

    }

    public static List<Integer> processArray(int[] input) {
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int val : input) {
            if (val < 0) {
                myLinkedList.insert(val);
            } else if (val > 0) {
                myLinkedList.remove(val);
            }
        }
        return myLinkedList.combine();
    }

    static class Node {
        int value;
        Node next;
        Node prev;
        Node(int value) {
            this.value = value;
        }
    }

    static class MyLinkedList {
        Node head;
        Node tail;
        int size;

        MyLinkedList() {
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }

        void insert(int value) {
            Node newNode = new Node(value);
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            tail.prev = newNode;
            newNode.next = tail;
            size++;
        }

        void remove(int index) {
            if (index <= size) {
                Node copy = head;
                for (int i = 0; i < index; i++) {
                    copy = copy.next;
                }
                copy.prev.next = copy.next;
                copy.next.prev = copy.prev;
                size--;
            }
        }

        List<Integer> combine() {
            List<Integer> result = new ArrayList<>(size);
            Node copy = head.next;
            while (copy != tail) {
                result.add(copy.value);
                copy = copy.next;
            }
            return result;
        }
    }

    public static void main(String[] args) {
//        System.out.println(Task.processArray(new int[] {-1,-2,-3,4}));
//        System.out.println(Task.processArrayBF(new int[]{-1, -2, -3, 2, 3, 0}));
//        System.out.println(Task.processArray(new int[]{-1, -2, -3, 2, 3, 0}));
//        System.out.println(Task.processArrayBF(new int[]{-1, -2, -3, 2, -1, -2, -1, 5, 10, -1, -2, -5, 1, 0, 0, -2, -5, 12, -1}));
        Random random = new Random();
        int[] input = Stream.generate(() -> random.nextInt(-255, 255)).limit(1_000_000).mapToInt(i -> i).toArray();
        int pos = 0;
        int zero = 0;
        int neg = 0;
        for (int val : input) {
            if (val < 0) {
                neg++;
            } else if (val > 0) {
                pos++;
            } else {
                zero++;
            }
        }

        System.out.println(pos + " " + zero + " " + neg);

        Instant start = Instant.now();
        Task.processArrayBF(input);
        Instant end = Instant.now();

        long millisDiff = ChronoUnit.MILLIS.between(start, end);
        System.out.println("Time difference: " + millisDiff + " milliseconds");
        System.out.println(counter);
        counter = 0;
        start = Instant.now();
        Task.processArray(input);
        end = Instant.now();

        millisDiff = ChronoUnit.MILLIS.between(start, end);
        System.out.println("Time difference: " + millisDiff + " milliseconds");
        System.out.println(counter);

    }
}
