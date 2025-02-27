package com.aklimets.data_structures.heaps.median_finder;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    /*
        The median is the middle value in a sorted list of integers. For lists of even length, there is no middle value, so the median is the mean of the two middle values.
        For example:

        For arr = [1,2,3], the median is 2.
        For arr = [1,2], the median is (1 + 2) / 2 = 1.5
        Implement the MedianFinder class:

        MedianFinder() initializes the MedianFinder object.
        void addNum(int num) adds the integer num from the data stream to the data structure.
        double findMedian() returns the median of all elements so far.
        Example 1:

        Input:
        ["MedianFinder", "addNum", "1", "findMedian", "addNum", "3" "findMedian", "addNum", "2", "findMedian"]

        Output:
        [null, null, 1.0, null, 2.0, null, 2.0]

        Explanation:
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.findMedian(); // return 1.0
        medianFinder.addNum(3);    // arr = [1, 3]
        medianFinder.findMedian(); // return 2.0
        medianFinder.addNum(2);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
        Constraints:

        -100,000 <= num <= 100,000
        findMedian will only be called after adding at least one integer to the data structure.
    */

    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            minHeap.offer(num);
        } else if (minHeap.size() >= maxHeap.size()) {
            if (minHeap.peek() > num) {
                maxHeap.offer(num);
            } else {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
        } else {
            if (maxHeap.peek() < num) {
                minHeap.offer(num);
            } else {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }
        }
    }

    public void addNum2(int num) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            minHeap.offer(num);
        } else if (minHeap.size() >= maxHeap.size()) {
            int poll = minHeap.poll();
            minHeap.offer(Math.max(num, poll));
            maxHeap.offer(Math.min(num, poll));
        } else {
            int poll = maxHeap.poll();
            minHeap.offer(Math.max(num, poll));
            maxHeap.offer(Math.min(num, poll));
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (minHeap.size() > maxHeap.size()) {
            return (double) minHeap.peek();
        } else {
            return (double) maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
