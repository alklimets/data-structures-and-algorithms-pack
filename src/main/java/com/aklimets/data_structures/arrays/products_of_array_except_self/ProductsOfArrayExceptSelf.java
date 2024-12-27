package com.aklimets.data_structures.arrays.products_of_array_except_self;

public class ProductsOfArrayExceptSelf {

    /*
        Products of Array Except Self
        Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].

        Each product is guaranteed to fit in a 32-bit integer.

        Follow-up: Could you solve it in O(n) time without using the division operation?

        Example 1:

        Input: nums = [1,2,4,6]

        Output: [48,24,12,8]
        Example 2:

        Input: nums = [-1,0,1,2,3]

        Output: [0,-6,0,0,0]

    */

    public int[] productExceptSelf(int[] nums) {
        int productWithoutZeros = 1;
        int zerosCount = 0;

        for (int num : nums) {
            if (num == 0) {
                zerosCount++;
            } else {
                productWithoutZeros *= num;
            }
        }
        int[] ints = new int[nums.length];
        if (zerosCount > 1) {
            return ints;
        }

        if (zerosCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) ints[i] = productWithoutZeros;
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                ints[i] = productWithoutZeros / nums[i];
            }
        }
        return ints;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int prefix = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            res[i] *= prefix;
            prefix *= nums[i];
        }
        return res;
    }

}
