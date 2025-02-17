package com.aklimets.data_structures.arrays.leetcode.largest_divisible_subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    /*
        Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

        answer[i] % answer[j] == 0, or
        answer[j] % answer[i] == 0
        If there are multiple solutions, return any of them.

        Example 1:
        Input: nums = [1,2,3]
        Output: [1,2]
        Explanation: [1,3] is also accepted.

        Example 2:
        Input: nums = [1,2,4,8]
        Output: [1,2,4,8]

        Constraints:

        1 <= nums.length <= 1000
        1 <= nums[i] <= 2 * 109
        All the integers in nums are unique.
    */

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        int[] parents = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(parents, -1);

        for(int i = 1; i < nums.length; i++) {
            int maxJ = -1;
            int maxValue = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[j] > maxValue) {
                    maxJ = j;
                    maxValue = dp[j];
                }
            }
            dp[i] += maxJ == -1 ? 0 : dp[maxJ];
            parents[i] = maxJ;
        }
        List<Integer> res = new ArrayList<>();

        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxValue) {
                maxValue = dp[i];
                maxIndex = i;
            }
        }

        while (maxIndex != -1) {
            res.add(nums[maxIndex]);
            maxIndex = parents[maxIndex];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[] {4,8,10,240}));
    }
}
