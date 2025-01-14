package com.aklimets.data_structures.arrays.leetcode.rotate_array;

public class RotateArray {

    /*
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
    Example 1:

    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
    Example 2:

    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation:
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]
    Constraints:

    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1
    0 <= k <= 105
    Follow up:

    Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
    Could you do it in-place with O(1) extra space?
    */

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int counter = 0;
        int index = 0;
        while (counter < nums.length) {
            int startIndex = index;
            int memo = nums[index];
            do {
                int nextIndex = index + k < nums.length ? index + k : index + k - nums.length;
                int buff = nums[nextIndex];
                nums[nextIndex] = memo;
                memo = buff;
                counter++;
                index = nextIndex;
            } while (index != startIndex);
            index++;
        }
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < (nums.length) / 2; i++) {
            int buff = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = buff;
        }

        for (int i = 0; i < k / 2; i++) {
            int buff = nums[i];
            nums[i] = nums[k - i - 1];
            nums[k - i - 1] = buff;
        }

        for (int i = k; i < (k + nums.length) / 2; i++) {
            int buff = nums[i];
            nums[i] = nums[nums.length - i - 1 + k];
            nums[nums.length - i - 1 + k] = buff;
        }
    }

    public static void main(String[] args) {
        new RotateArray().rotate2(new int[] {1,2,3,4,5,6,7}, 2);
    }
}
