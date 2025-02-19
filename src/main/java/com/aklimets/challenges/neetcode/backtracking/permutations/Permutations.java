package com.aklimets.challenges.neetcode.backtracking.permutations;

import java.util.ArrayList;
import java.util.Arrays;
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

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> cur = new LinkedList<>();
        backtrack(nums, cur, new boolean[nums.length]);
        return res;
    }

    public List<List<Integer>> permute2(int[] nums) {
        backtrack2(nums, 0);
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

    public void backtrack2(int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack2(nums, start + 1);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int buf = nums[i];
        nums[i] = nums[j];
        nums[j] = buf;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        // does not work with arrays
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a);
        System.out.println(b);

        System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
        System.out.println(new Permutations().permute2(new int[]{1, 2, 3}));
    }
}
