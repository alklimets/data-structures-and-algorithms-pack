package com.aklimets.challenges.neetcode.backtracking.permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    /*
        Given an array nums of unique integers, return all the possible permutations. You may return the answer in any order.

        Example 1:

        Input: nums = [1,2,3]

        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        Example 2:

        Input: nums = [7]

        Output: [[7]]
        Constraints:

        1 <= nums.length <= 6
        -10 <= nums[i] <= 10
    */

    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        backtrack(nums, cur, new boolean[nums.length]);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> cur, boolean[] picked) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!picked[i]) {
                picked[i] = true;
                cur.add(nums[i]);
                backtrack(nums, cur, picked);
                picked[i] = false;
                cur.removeLast();
            }
        }
    }
}
