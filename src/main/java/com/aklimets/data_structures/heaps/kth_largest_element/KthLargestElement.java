package com.aklimets.data_structures.heaps.kth_largest_element;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

    /*
        Given an unsorted array of integers nums and an integer k, return the kth largest element in the array.
        By kth largest element, we mean the kth largest element in the sorted order, not the kth distinct element.
        Follow-up: Can you solve it without sorting?

        Example 1:
        Input: nums = [2,3,1,5,4], k = 2
        Output: 4

        Example 2:
        Input: nums = [2,3,1,1,5,5,4], k = 3
        Output: 4

        Constraints:

        1 <= k <= nums.length <= 10000
        -1000 <= nums[i] <= 1000
    */

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
