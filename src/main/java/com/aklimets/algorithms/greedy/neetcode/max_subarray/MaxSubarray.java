package com.aklimets.algorithms.greedy.neetcode.max_subarray;

public class MaxSubarray {

    /*
        Maximum Subarray
        Given an array of integers nums, find the subarray with the largest sum and return the sum.

        A subarray is a contiguous non-empty sequence of elements within an array.

        Example 1:

        Input: nums = [2,-3,4,-2,2,1,-1,4]

        Output: 8
        Explanation: The subarray [4,-2,2,1,-1,4] has the largest sum 8.

        Example 2:

        Input: nums = [-1]

        Output: -1
        Constraints:

        1 <= nums.length <= 1000
        -1000 <= nums[i] <= 1000
    */

    // BF
    public int maxSubArray(int[] nums) {
        int max = -1_000_000;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int max = -1_000_000;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubarray().maxSubArray2(new int[] {2,-3,4,-2,2,1,-1,4}));
        System.out.println(new MaxSubarray().maxSubArray2(new int[] {-2, 1}));
        System.out.println(new MaxSubarray().maxSubArray2(new int[] {-2, -1}));
    }
}
