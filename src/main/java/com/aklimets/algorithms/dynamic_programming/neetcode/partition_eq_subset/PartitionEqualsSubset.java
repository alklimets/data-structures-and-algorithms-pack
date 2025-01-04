package com.aklimets.algorithms.dynamic_programming.neetcode.partition_eq_subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualsSubset {

    /*
        Partition Equal Subset Sum
        You are given an array of positive integers nums.

        Return true if you can partition the array into two subsets, subset1 and subset2 where sum(subset1) == sum(subset2). Otherwise, return false.

        Example 1:

        Input: nums = [1,2,3,4]

        Output: true
        Explanation: The array can be partitioned as [1, 4] and [2, 3].

        Example 2:

        Input: nums = [1,2,3,4,5]

        Output: false
        Constraints:

        1 <= nums.length <= 100
        1 <= nums[i] <= 50
    */

    // DP with hashset
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;

        int desired = sum / 2;
        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        sums.add(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            for (Integer val : new ArrayList<>(sums)) {
                sums.add(val + nums[i]);
            }
            if (sums.contains(desired)) return true;
        }
        return false;
    }

    // BF
//    private boolean canPartition(int[] nums, int desiredSum, int currentSum, int index) {
//        if (index == nums.length - 1) {
//            return currentSum + nums[index] == desiredSum;
//        }
//        if (currentSum + nums[index] == desiredSum) return true;
//        boolean res = false;
//        if (currentSum + nums[index] < desiredSum) {
//            boolean with = canPartition(nums, desiredSum, currentSum + nums[index], index + 1);
//            res = res || with;
//        }
//        if (currentSum < desiredSum) {
//            boolean without = canPartition(nums, desiredSum, currentSum, index + 1);
//            res = res || without;
//        }
//
//        return res;
//    }

//    private boolean canPartition(int[] nums, int desiredSum, int index) {
//        if (nums[index] == desiredSum) {
//            return true;
//        }
//        boolean res = false;
//        for (int i = index + 1; i < nums.length - 1; i++) {
//            if (desiredSum >= nums[i]) {
//                boolean without = canPartition(nums, desiredSum, index + 1);
//                res = res || without;
//            }
//
//            if (desiredSum - nums[index] >= nums[i]) {
//                boolean without = canPartition(nums, desiredSum - nums[index], index + 1);
//                res = res || without;
//            }
//        }
//        return res;
//    }

    // DP
    public boolean canPartitionDP(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int[][] dp = new int[n][target + 1];

        for (int i = 1; i <= target; i++) {
            dp[0][i] = nums[0] > i ? i : i - nums[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - nums[i]], dp[i - 1][j]);
                }
            }
        }

        return dp[n - 1][target] == 0;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionEqualsSubset().canPartitionDP(new int[] {8, 7, 4, 5}));
    }

}
