package com.aklimets.data_structures.arrays.leetcode.majority_element2;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {

    /*
            Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
            Example 1:

            Input: nums = [3,2,3]
            Output: [3]
            Example 2:

            Input: nums = [1]
            Output: [1]
            Example 3:

            Input: nums = [1,2]
            Output: [1,2]
            Constraints:

            1 <= nums.length <= 5 * 104
            -109 <= nums[i] <= 109


            Follow up: Could you solve the problem in linear time and in O(1) space?
    */

    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = null;
        Integer candidate2 = null;

        int count1 = 0;
        int count2 = 0;
        for (int n: nums) {
            if (candidate1 != null && candidate1 == n) {
                count1++;
            } else if (candidate2 != null && candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        int c1 = 0;
        int c2 = 0;

        for (int num : nums) {
            if (candidate1 != null && num == candidate1) c1++;
            if (candidate2 != null && num == candidate2) c2++;
        }

        List<Integer> res = new ArrayList<>();
        if (c1 > nums.length / 3) res.add(candidate1);
        if (c2 > nums.length / 3) res.add(candidate2);
        return res;

    }
}
