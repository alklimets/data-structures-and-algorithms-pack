package com.aklimets.algorithms.dynamic_programming.neetcode.longest_increasing_subsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {

    /*
        Longest Increasing Subsequence
        Given an integer array nums, return the length of the longest strictly increasing subsequence.

        A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the relative order of the remaining characters.

        For example, "cat" is a subsequence of "crabt".
        Example 1:

        Input: nums = [9,1,4,2,3,3,7]

        Output: 4
        Explanation: The longest increasing subsequence is [1,2,3,7], which has a length of 4.

        Example 2:

        Input: nums = [0,3,1,3,2,3]

        Output: 4
        Constraints:

        1 <= nums.length <= 1000
        -1000 <= nums[i] <= 1000
    */

    Map<Integer, Integer> memo = new HashMap<>();

    public int lengthOfLIS(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, lengthOfLIS(nums, i));
        }
        return max;
    }

    public int lengthOfLIS(int[] nums, int start) {
        if (start == nums.length - 1) return 1;
        if (memo.containsKey(start)) return memo.get(start);
        int max = 1;
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] > nums[start]) {
                int temp = 1 + lengthOfLIS(nums, i);
                max = Math.max(temp, max);
            }
        }
        memo.put(start, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
