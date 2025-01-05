package com.aklimets.data_structures.arrays.neetcode.top_k_frequent;

import java.util.*;

public class TopKFrequent {

    /*
        Top K Frequent Elements
        Given an integer array nums and an integer k, return the k most frequent elements within the array.

        The test cases are generated such that the answer is always unique.

        You may return the output in any order.

        Example 1:

        Input: nums = [1,2,2,3,3,3], k = 2

        Output: [2,3]
        Example 2:

        Input: nums = [7,7], k = 1

        Output: [7]
        Constraints:

        1 <= nums.length <= 10^4.
        -1000 <= nums[i] <= 1000
        1 <= k <= number of distinct elements in nums.
    */

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (key, v) -> v == null ? 1 : v + 1);
        }
        return map.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (key, v) -> v == null ? 1 : v + 1);
        }
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        map.forEach((key, value) -> {
            freq[value].add(key);
        });

        int[] res = new int[k];
        for (int i = freq.length - 1; i > 0; i--) {
            for (Integer fr : freq[i]) {
                res[--k] = fr;
                if (k == 0) return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent2(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4}, 2)));
    }


}
