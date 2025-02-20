package com.aklimets.challenges.neetcode.binary_search.first_and_last_position;

import java.util.Arrays;

public class FirstAndLastPosition {

    /*
        Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
        If target is not found in the array, return [-1, -1].
        You must write an algorithm with O(log n) runtime complexity.

        Example 1:
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]

        Example 2:
        Input: nums = [5,7,7,8,8,10], target = 6
        Output: [-1,-1]

        Example 3:
        Input: nums = [], target = 0
        Output: [-1,-1]

        Constraints:

        0 <= nums.length <= 10^5
        -10^9 <= nums[i] <= 10^9
        nums is a non-decreasing array.
        -10^9 <= target <= 10^9
    */

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        if (nums.length == 0) return res;
        int l = 0, r = nums.length - 1;
        int mid = 0;
        // left most
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) break;
                r = mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (nums[mid] == target) res[0] = mid;

        l = 0;
        r = nums.length - 1;
        // right most
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) break;
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (nums[mid] == target) res[1] = mid;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FirstAndLastPosition().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }
}
