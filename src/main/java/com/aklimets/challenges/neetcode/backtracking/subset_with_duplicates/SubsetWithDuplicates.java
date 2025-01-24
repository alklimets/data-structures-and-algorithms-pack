package com.aklimets.challenges.neetcode.backtracking.subset_with_duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetWithDuplicates {

    /*
        You are given an array nums of integers, which may contain duplicates. Return all possible subsets.

        The solution must not contain duplicate subsets. You may return the solution in any order.

        Example 1:

        Input: nums = [1,2,1]

        Output: [[],[1],[1,2],[1,1],[1,2,1],[2]]
        Example 2:

        Input: nums = [7,7]

        Output: [[],[7], [7,7]]
        Constraints:

        1 <= nums.length <= 11
        -20 <= nums[i] <= 20
    */

    // BF
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new LinkedList<>());
        return res.stream().peek(arr -> arr.sort((a, b) -> a - b)).distinct().collect(Collectors.toList());
    }

    void dfs(int[] nums, int start, List<List<Integer>> result, LinkedList<Integer> backtrack) {
        result.add(new ArrayList<>(backtrack));
        for (int i = start; i < nums.length; i++) {
            backtrack.add(nums[i]);
            dfs(nums, i + 1, result, backtrack);
            backtrack.removeLast();
        }
    }



    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, res, new LinkedList<>());
        return res;
    }

    void dfs2(int[] nums, int i, List<List<Integer>> result, LinkedList<Integer> backtrack) {
        if (i == nums.length) {
            result.add(new ArrayList<>(backtrack));
            return;
        }
        backtrack.add(nums[i]);
        dfs2(nums, i + 1, result, backtrack);
        backtrack.removeLast();
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        dfs2(nums, i + 1, result, backtrack);
    }



    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, res, new LinkedList<>());
        return res;
    }

    void dfs3(int[] nums, int start, List<List<Integer>> result, LinkedList<Integer> backtrack) {
        result.add(new ArrayList<>(backtrack));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            backtrack.add(nums[i]);
            dfs3(nums, i + 1, result, backtrack);
            backtrack.removeLast();
        }
    }
}
