package com.aklimets.data_structures.arrays.leetcode.sub_arr_sum_eq_k;

public class SubArraySumEqualsK {
    public static int subarraySum(int[] nums1, int k) {
        int sum = 0;
        int[] nums = new int[nums1.length + 1];
        nums[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums1[i - 1] + nums[i - 1];
        }
        int l = 1, r = 1;
        while (r < nums.length && l <= r) {
            int diff = nums[r] - nums[l - 1];
            if (diff == k) {
                l++;
                r++;
                sum++;
            } else if (diff < k) {
                r++;
            } else {
                l++;
            }
        }
        r--;
        while (l <= r) {
            int diff = nums[r] - nums[l - 1];
            if (diff == k) {
                sum++;
            }
            l++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }
}
