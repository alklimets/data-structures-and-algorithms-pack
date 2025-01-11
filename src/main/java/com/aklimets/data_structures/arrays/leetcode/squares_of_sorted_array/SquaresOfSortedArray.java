package com.aklimets.data_structures.arrays.leetcode.squares_of_sorted_array;

public class SquaresOfSortedArray {

    /*
        Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

        Example 1:

        Input: nums = [-4,-1,0,3,10]
        Output: [0,1,9,16,100]
        Explanation: After squaring, the array becomes [16,1,0,9,100].
        After sorting, it becomes [0,1,9,16,100].
        Example 2:

        Input: nums = [-7,-3,2,3,11]
        Output: [4,9,9,49,121]


        Constraints:

        1 <= nums.length <= 10^4
        -10^4 <= nums[i] <= 10^4
        nums is sorted in non-decreasing order.
    */

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int index = res.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[index--] = nums[left] * nums[left++];
            } else {
                res[index--] = nums[right] * nums[right--];
            }
        }
        return res;
    }
}
