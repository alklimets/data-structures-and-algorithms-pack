package com.aklimets.algorithms.dynamic_programming.neetcode.target_sum;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    /*
        Target Sum
        You are given an array of integers nums and an integer target.

        For each number in the array, you can choose to either add or subtract it to a total sum.

        For example, if nums = [1, 2], one possible sum would be "+1-2=-1".
        If nums=[1,1], there are two different ways to sum the input numbers to get a sum of 0: "+1-1" and "-1+1".

        Return the number of different ways that you can build the expression such that the total sum equals target.

        Example 1:

        Input: nums = [2,2,2], target = 2

        Output: 3
        Explanation: There are 3 different ways to sum the input numbers to get a sum of 2.
        +2 +2 -2 = 2
        +2 -2 +2 = 2
        -2 +2 +2 = 2

        Constraints:

        1 <= nums.length <= 20
        0 <= nums[i] <= 1000
        -1000 <= target <= 1000
    */

    private Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, target, 0, 0);
    }

    public int findTargetSumWays(int[] nums, int target, int index, int current) {
        if (index == nums.length) return current == target ? 1 : 0;
        if (memo.containsKey(index + "#" + current)) return  memo.get(index + "#" + current);
        int minus = findTargetSumWays(nums, target, index + 1, current - nums[index]);
        int plus = findTargetSumWays(nums, target, index + 1, current + nums[index]);
        memo.put(index + "#" + current, minus + plus);
        return minus + plus;
    }

    /*
        Just in case - this solution is a great example of how memoization affects the performance. With memo commented
        the amount of method calls for input of length 20 will be 1048575, but with memoization it is only 210.
    */
    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, 0));
    }
}
