package com.aklimets.algorithms.dynamic_programming.neetcode.house_robber;

public class HouseRobber {

    /*
        House Robber
        You are given an integer array nums where nums[i] represents the amount of money the ith house has. The houses are arranged in a straight line, i.e. the ith house is the neighbor of the (i-1)th and (i+1)th house.

        You are planning to rob money from the houses, but you cannot rob two adjacent houses because the security system will automatically alert the police if two adjacent houses were both broken into.

        Return the maximum amount of money you can rob without alerting the police.

        Example 1:

        Input: nums = [1,1,3,3]

        Output: 4
        Explanation: nums[0] + nums[2] = 1 + 3 = 4.

        Example 2:

        Input: nums = [2,9,8,3,6]

        Output: 16
        Explanation: nums[0] + nums[2] + nums[4] = 2 + 8 + 6 = 16.

        Constraints:

        1 <= nums.length <= 100
        0 <= nums[i] <= 100
    */

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[1], nums[0] + nums[2]);
        nums[2] = nums[2] + nums[0];
        for (int i = 3; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i] + nums[i - 3]);
        }

        return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    }

    public int rob2(int[] nums) {
        int one = 0, two = 0;

        for (int num : nums) {
            int temp = Math.max(one + num, two);
            one = two;
            two = temp;
        }
        return two;
    }
}
