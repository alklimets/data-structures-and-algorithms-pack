package com.aklimets.data_structures.arrays.leetcode.four_sum;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Long>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                Map<Long, Integer> map = new HashMap<>();
                long tempTarget = (long)target - nums[i] - nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (map.containsKey(tempTarget - nums[k])) {
                        List<Long> list = new ArrayList<>();
                        list.add((long) nums[i]);
                        list.add((long) nums[j]);
                        list.add((long) nums[map.get(tempTarget - nums[k])]);
                        list.add((long) nums[k]);
                        result.add(list);
                    }
                    map.put((long) nums[k], k);
                }
            }
        }
        return result.stream().map(l -> {
            List<Integer> list = new ArrayList();
            for (long val : l) {
                list.add((int) val);
            }
            return list;
        }).toList();

    }
}
