package com.aklimets.challenges.neetcode.backtracking.partition_to_k_eq_sum_subsets;

import java.util.Arrays;

public class PartitionTokEqSumSubsets {

    /*
        Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
        Example 1:
        Input: nums = [4,3,2,3,5,2,1], k = 4
        Output: true
        Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

        Example 2:
        Input: nums = [1,2,3,4], k = 3
        Output: false

        Constraints:

        1 <= k <= nums.length <= 16
        1 <= nums[i] <= 10^4
        The frequency of each element is in the range [1, 4].
    */

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % k > 0) return false;
        Arrays.sort(nums);
        return dfs(nums, k, 0, new boolean[nums.length], 0, sum / k);
    }

    private boolean dfs(int[] nums, int k, int start, boolean[] visited, int sum, int target) {
        if (k == 0) return true;

        if (sum == target) {
            return dfs(nums, k - 1, 0, visited, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            if (sum + nums[i] > target) continue;

            sum += nums[i];
            visited[i] = true;
            if (dfs(nums, k, i + 1, visited, sum, target)) return true;
            sum -= nums[i];
            visited[i] = false;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionTokEqSumSubsets().canPartitionKSubsets(new int[] {4,3,2,3,5,2,1}, 4));
    }
}
