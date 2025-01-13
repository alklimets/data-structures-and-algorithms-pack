package com.aklimets.challenges.neetcode.binary_search.median_of_two_sorted_arrays;

public class MedianOfTwoSortedArrays {

    /*
        Median of Two Sorted Arrays
        You are given two integer arrays nums1 and nums2 of size m and n respectively, where each is sorted in ascending order. Return the median value among all elements of the two arrays.

        Your solution must run in  O(log(m+n)) time.

        Example 1:

        Input: nums1 = [1,2], nums2 = [3]

        Output: 2.0
        Explanation: Among [1, 2, 3] the median is 2.

        Example 2:

        Input: nums1 = [1,3], nums2 = [2,4]

        Output: 2.5
        Explanation: Among [1, 2, 3, 4] the median is (2 + 3) / 2 = 2.5.

        Constraints:

        nums1.length == m
        nums2.length == n
        0 <= m <= 1000
        0 <= n <= 1000
        -10^6 <= nums1[i], nums2[i] <= 10^6
    */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        if (nums2.length < nums1.length) {
            int[] buff = nums2;
            nums2 = nums1;
            nums1 = buff;
        }

        int l = 0, r = nums1.length;
        while (l <= r) {
            int iMiddle = (l + r) / 2;
            int jMiddle = half - iMiddle;

            int aLeft = iMiddle > 0 ? nums1[iMiddle - 1] : Integer.MIN_VALUE;
            int aRight = iMiddle < nums1.length ? nums1[iMiddle] : Integer.MAX_VALUE;


            int bLeft = jMiddle > 0 ? nums2[jMiddle - 1] : Integer.MIN_VALUE;
            int bRight = jMiddle < nums2.length ? nums2[jMiddle] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 == 1) {
                    return Math.max(aLeft, bLeft);
                }
                return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
            }

            if (aLeft > bRight) {
                r = iMiddle - 1;
            } else {
                l = iMiddle + 1;
            }
        }

        return -1;

    }
}