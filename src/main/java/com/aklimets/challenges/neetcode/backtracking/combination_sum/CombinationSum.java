package com.aklimets.challenges.neetcode.backtracking.combination_sum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    /*
        You are given an array of distinct integers nums and a target integer target. Your task is to return a list of all unique combinations of nums where the chosen numbers sum to target.
        The same number may be chosen from nums an unlimited number of times. Two combinations are the same if the frequency of each of the chosen numbers is the same, otherwise they are different.
        You may return the combinations in any order and the order of the numbers in each combination can be in any order.

        Example 1:
        Input:
        nums = [2,5,6,9]
        target = 9
        Output: [[2,2,5],[9]]
        Explanation:
        2 + 2 + 5 = 9. We use 2 twice, and 5 once.
        9 = 9. We use 9 once.

        Example 2:
        Input:
        nums = [3,4,5]
        target = 16
        Output: [[3,3,3,3,4],[3,3,5,5],[4,4,4,4],[3,4,4,5]]

        Example 3:
        Input:
        nums = [3]
        target = 5
        Output: []

        Constraints:

        All elements of nums are distinct.
        1 <= nums.length <= 20
        2 <= nums[i] <= 30
        2 <= target <= 30
    */

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        backtrack(nums, target, res, curr, 0);
        return res;
    }

    private void backtrack(int[] nums, int target,  List<List<Integer>> res, LinkedList<Integer> curr, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        curr.add(nums[i]);
        backtrack(nums, target - nums[i], res, curr, i);
        curr.removeLast();
        backtrack(nums, target, res, curr, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[] {2,5,6,9}, 9));
    }
}
