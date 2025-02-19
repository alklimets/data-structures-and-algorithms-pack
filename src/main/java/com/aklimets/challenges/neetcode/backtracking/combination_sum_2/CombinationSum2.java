package com.aklimets.challenges.neetcode.backtracking.combination_sum_2;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum2 {

    /*
        You are given an array of integers candidates, which may contain duplicates, and a target integer target. Your task is to return a list of all unique combinations of candidates where the chosen numbers sum to target.
        Each element from candidates may be chosen at most once within a combination. The solution set must not contain duplicate combinations.
        You may return the combinations in any order and the order of the numbers in each combination can be in any order.

        Example 1:
        Input: candidates = [9,2,2,4,6,1,5], target = 8

        Output: [
          [1,2,5],
          [2,2,4],
          [2,6]
        ]
        Example 2:

        Input: candidates = [1,2,3,4,5], target = 7

        Output: [
          [1,2,4],
          [2,5],
          [3,4]
        ]
        Constraints:

        1 <= candidates.length <= 100
        1 <= candidates[i] <= 50
        1 <= target <= 30

    */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        backtrack(candidates, target, 0, res, cur);
        return res.stream().peek(arr -> arr.sort((a, b) -> a - b)).distinct().collect(Collectors.toList());
    }

    void backtrack(int[] candidates, int target, int ind, List<List<Integer>> res, LinkedList<Integer> cur) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (target < 0) return;

        for (int i = ind; i < candidates.length; i++) {
            cur.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, res, cur);
            cur.removeLast();
        }
    }

    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        LinkedList<Integer> curr = new LinkedList<>();
        backtrack(candidates, target, res, curr, 0);
        return new ArrayList<>(res);
    }

    private void backtrack(int[] nums, int target,  Set<List<Integer>> res, LinkedList<Integer> curr, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        curr.add(nums[i]);
        backtrack(nums, target - nums[i], res, curr, i + 1);
        curr.removeLast();
        backtrack(nums, target, res, curr, i + 1);

    }

    public List<List<Integer>> combinationSum23(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack3(candidates, target, 0, res, cur);
        return res;
    }

    void backtrack3(int[] candidates, int target, int ind, List<List<Integer>> res, LinkedList<Integer> cur) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (target < 0) return;

        for (int i = ind; i < candidates.length; i++) {
            if (i > ind && candidates[i] == candidates[i - 1]) continue;
            cur.add(candidates[i]);
            backtrack3(candidates, target - candidates[i], i + 1, res, cur);
            cur.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[] {9,2,2,4,6,1,5}, 8));
    }
}
