package com.aklimets.data_structures.arrays.leetcode.first_missing_positive;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    /*
        Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
        You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

        Example 1:

        Input: nums = [1,2,0]
        Output: 3
        Explanation: The numbers in the range [1,2] are all in the array.
        Example 2:

        Input: nums = [3,4,-1,1]
        Output: 2
        Explanation: 1 is in the array but 2 is missing.
        Example 3:

        Input: nums = [7,8,9,11,12]
        Output: 1
        Explanation: The smallest positive integer 1 is missing.


        Constraints:

        1 <= nums.length <= 10^5
        -2^31 <= nums[i] <= 2^31 - 1

    */

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min > 1 || max <= 0) return 1;
        for (int i = Math.max(min, 1); i <= max; i++) {
            if (!set.contains(i)) return i;
        }
        return max + 1;
    }
}
