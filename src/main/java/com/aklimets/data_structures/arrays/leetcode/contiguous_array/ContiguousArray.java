package com.aklimets.data_structures.arrays.leetcode.contiguous_array;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    /*
        Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

        Example 1:
        Input: nums = [0,1]
        Output: 2
        Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

        Example 2:
        Input: nums = [0,1,0]
        Output: 2

        Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

        Constraints:

        1 <= nums.length <= 10^5
        nums[i] is either 0 or 1.
    */

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            memo.putIfAbsent(sum, i);

            max = Math.max(max, i - memo.get(sum));
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0, 0, 1, 0, 1, 1, 0, 1}));
    }
}
