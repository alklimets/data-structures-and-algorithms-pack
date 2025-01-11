package com.aklimets.data_structures.arrays.leetcode.third_distinct_max;

import java.util.HashSet;
import java.util.Set;

public class ThirdDistinctMax {

    /*
        Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

        Example 1:

        Input: nums = [3,2,1]
        Output: 1
        Explanation:
        The first distinct maximum is 3.
        The second distinct maximum is 2.
        The third distinct maximum is 1.
        Example 2:

        Input: nums = [1,2]
        Output: 2
        Explanation:
        The first distinct maximum is 2.
        The second distinct maximum is 1.
        The third distinct maximum does not exist, so the maximum (2) is returned instead.
        Example 3:

        Input: nums = [2,2,3,1]
        Output: 1
        Explanation:
        The first distinct maximum is 3.
        The second distinct maximum is 2 (both 2's are counted together since they have the same value).
        The third distinct maximum is 1.


        Constraints:

        1 <= nums.length <= 10^4
        -2^31 <= nums[i] <= 2^31 - 1

    */

    public int thirdMax(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        Integer max = null, max1 = null, max2 = null;
        for (int num : nums) {
            if (visited.contains(num)) continue;
            visited.add(num);
            if (max == null || num > max) {
                max2 = max1;
                max1 = max;
                max = num;
            } else if (max1 == null || num > max1) {
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max2 = num;
            }
        }
        return max2 != null ? max2 : max;
    }
}
