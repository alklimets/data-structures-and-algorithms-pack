package com.aklimets.data_structures.arrays.neetcode.contains_duplicates;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
    /*
    Contains Duplicate
    Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

    Example 1:

    Input: nums = [1, 2, 3, 3]
    Output: true

    Example 2:

    Input: nums = [1, 2, 3, 4]
    Output: false
    */

    // optimal, O(n)
    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int i : nums) {
            if (seen.contains(i)) {
                return true;
            }
            seen.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate(new int[]{1,2,3,3}));
        System.out.println(hasDuplicate(new int[]{1,2,3,4}));
    }
}
