package com.aklimets.challenges.neetcode.backtracking.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    /*
        Given an integer array nums of unique elements, return all possible subsets
         (the power set).

        The solution set must not contain duplicate subsets. Return the solution in any order.

        Example 1:

        Input: nums = [1,2,3]
        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        Example 2:

        Input: nums = [0]
        Output: [[],[0]]

        Constraints:

        1 <= nums.length <= 10
        -10 <= nums[i] <= 10
        All the numbers of nums are unique.
    */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new LinkedList<>());
        return res;
    }

    void dfs(int[] nums, int start, List<List<Integer>> result, LinkedList<Integer> backtrack) {
        result.add(new ArrayList<>(backtrack));
        for (int i = start; i < nums.length; i++) {
            backtrack.add(nums[i]);
            dfs(nums, i + 1, result, backtrack);
            backtrack.removeLast();
        }
    }
}
