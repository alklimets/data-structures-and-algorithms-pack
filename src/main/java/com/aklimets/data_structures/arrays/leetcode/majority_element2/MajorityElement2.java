package com.aklimets.data_structures.arrays.leetcode.majority_element2;

import java.util.*;

public class MajorityElement2 {

    /*
            Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
            Example 1:

            Input: nums = [3,2,3]
            Output: [3]
            Example 2:

            Input: nums = [1]
            Output: [1]
            Example 3:

            Input: nums = [1,2]
            Output: [1,2]
            Constraints:

            1 <= nums.length <= 5 * 10^4
            -10^9 <= nums[i] <= 10^9


            Follow up: Could you solve the problem in linear time and in O(1) space?
    */

    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = null;
        Integer candidate2 = null;

        int count1 = 0;
        int count2 = 0;
        for (int n: nums) {
            if (candidate1 != null && candidate1 == n) {
                count1++;
            } else if (candidate2 != null && candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        int c1 = 0;
        int c2 = 0;

        for (int num : nums) {
            if (candidate1 != null && num == candidate1) c1++;
            if (candidate2 != null && num == candidate2) c2++;
        }

        List<Integer> res = new ArrayList<>();
        if (c1 > nums.length / 3) res.add(candidate1);
        if (c2 > nums.length / 3) res.add(candidate2);
        return res;
    }

    public List<Integer> majorityElement2(int[] nums) {
        if (nums.length == 1) return List.of(nums[0]);
        Map<Integer, Integer> counters = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (int num : nums) {
            counters.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }
        for (Map.Entry<Integer, Integer> entry : counters.entrySet()) {
            heap.offer(entry);
        }

        Map.Entry<Integer, Integer> candidate1 = heap.poll();
        Map.Entry<Integer, Integer> candidate2= heap.poll();

        List<Integer> res = new ArrayList<>();
        if (candidate1.getValue() > nums.length / 3) res.add(candidate1.getKey());
        if (candidate2.getValue() > nums.length / 3) res.add(candidate2.getKey());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement2().majorityElement(new int[] {3,2,2,3}));
        System.out.println(new MajorityElement2().majorityElement2(new int[] {3,2,2,3}));
    }
}
