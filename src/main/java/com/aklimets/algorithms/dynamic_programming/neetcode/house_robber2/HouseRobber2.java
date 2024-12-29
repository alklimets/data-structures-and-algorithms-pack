package com.aklimets.algorithms.dynamic_programming.neetcode.house_robber2;

public class HouseRobber2 {
    /*
        House Robber II
        You are given an integer array nums where nums[i] represents the amount of money the ith house has. The houses are arranged in a circle, i.e. the first house and the last house are neighbors.

        You are planning to rob money from the houses, but you cannot rob two adjacent houses because the security system will automatically alert the police if two adjacent houses were both broken into.

        Return the maximum amount of money you can rob without alerting the police.

        Example 1:

        Input: nums = [3,4,3]

        Output: 4
        Explanation: You cannot rob nums[0] + nums[2] = 6 because nums[0] and nums[2] are adjacent houses. The maximum you can rob is nums[1] = 4.

        Example 2:

        Input: nums = [2,9,8,3,6]

        Output: 15
        Explanation: You cannot rob nums[0] + nums[2] + nums[4] = 16 because nums[0] and nums[4] are adjacent houses. The maximum you can rob is nums[1] + nums[4] = 15.

        Constraints:

        1 <= nums.length <= 100
        0 <= nums[i] <= 100
    */

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int start, int end) {
        int one = 0, two = 0;

        for (int i = start; i < end; i++) {
            int temp = Math.max(one + nums[i], two);
            one = two;
            two = temp;
        }
        return two;
    }

}
