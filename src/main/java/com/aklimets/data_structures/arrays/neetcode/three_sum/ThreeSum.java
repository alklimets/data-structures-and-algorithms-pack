package com.aklimets.data_structures.arrays.neetcode.three_sum;

import java.util.*;

public class ThreeSum {

    /*
        3Sum
        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.

        The output should not contain any duplicate triplets. You may return the output and the triplets in any order.

        Example 1:

        Input: nums = [-1,0,1,2,-1,-4]

        Output: [[-1,-1,2],[-1,0,1]]
        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].

        Example 2:

        Input: nums = [0,1,1]

        Output: []
        Explanation: The only possible triplet does not sum up to 0.

        Example 3:

        Input: nums = [0,0,0]

        Output: [[0,0,0]]
        Explanation: The only possible triplet sums up to 0.

        Constraints:

        3 <= nums.length <= 1000
        -10^5 <= nums[i] <= 10^5
    */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            Map<Integer, Integer> memo = new HashMap<>();
            int val = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (memo.containsKey(val - nums[j])) {
                    res.add(List.of(nums[i], nums[j], nums[memo.get(val - nums[j])]));
                }
                memo.put(nums[j], j);
            }
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[] {-1,0,1,2,-1,-4});
    }
}
