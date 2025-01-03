package com.aklimets.algorithms.dynamic_programming.neetcode.max_product_subarray;

import java.util.HashMap;
import java.util.Map;

public class MaxProductSubarray {

    /*
        Maximum Product Subarray
        Given an integer array nums, find a subarray that has the largest product within the array and return it.

        A subarray is a contiguous non-empty sequence of elements within an array.

        You can assume the output will fit into a 32-bit integer.

        Example 1:

        Input: nums = [1,2,-3,4]

        Output: 4
        Example 2:

        Input: nums = [-2,-1]

        Output: 2
        Constraints:

        1 <= nums.length <= 1000
        -10 <= nums[i] <= 10
    */

    private Map<String, Integer> memo = new HashMap<>();

    public int maxProduct(int[] nums) {
        return maxProduct(nums, 0, nums.length - 1);
    }

    public int maxProduct(int[] nums, int start, int finish) {
        if (start == finish) return nums[start];
        if (memo.containsKey(getKey(start, finish))) {
            System.out.println("Checked " + start + " " + finish);
            return memo.get(getKey(start,finish));
        }
        int left = maxProduct(nums, start, finish - 1);
        int right = maxProduct(nums, start + 1, finish);
        int product = 1;
        for (int i = start; i <= finish; i++) {
            product *= nums[i];
        }
        int min = Math.max(product, Math.max(left, right));
        memo.put(getKey(start, finish), min);
        return min;
    }

    private String getKey(int s, int f) {
        return s + "#" + f;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProductSubarray().maxProduct(new int[] {1,2,-3,4, 8, 9, 1, 0, 5}));
        System.out.println();
    }

}
