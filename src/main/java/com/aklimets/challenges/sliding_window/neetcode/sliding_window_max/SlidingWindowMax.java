package com.aklimets.challenges.sliding_window.neetcode.sliding_window_max;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMax {

    /*
        Sliding Window Maximum
        You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the left edge of the array. The window slides one position to the right until it reaches the right edge of the array.

        Return a list that contains the maximum element in the window at each step.

        Example 1:

        Input: nums = [1,2,1,0,4,2,6], k = 3

        Output: [2,2,4,4,6]

        Explanation:
        Window position            Max
        ---------------           -----
        [1  2  1] 0  4  2  6        2
         1 [2  1  0] 4  2  6        2
         1  2 [1  0  4] 2  6        4
         1  2  1 [0  4  2] 6        4
         1  2  1  0 [4  2  6]       6
        Constraints:

        1 <= nums.length <= 1000
        -1000 <= nums[i] <= 1000
        1 <= k <= nums.length
    */

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int l = 0, r = k - 1, index = 0;
        for (int i = 0; i <k; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        while (r < nums.length) {
            int max = deque.getFirst();
            res[index++] = max;
            if (nums[l++] == max) deque.removeFirst();
            r++;
            if (r < nums.length) {
                while (!deque.isEmpty() && deque.getLast() < nums[r]) {
                    deque.removeLast();
                }
                deque.addLast(nums[r]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString( new SlidingWindowMax().maxSlidingWindow(new int[] {10,9,8,7,6,5}, 3)));
    }
}
