package com.aklimets.data_structures.arrays.leetcode.valid_mountain;

public class ValidMountain {

    /*
    Given an array of integers arr, return true if and only if it is a valid mountain array.

    Recall that arr is a mountain array if and only if:

    arr.length >= 3
    There exists some i with 0 < i < arr.length - 1 such that:
    arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
    arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

    Example 1:

        Input: arr = [2,1]
        Output: false
        Example 2:

        Input: arr = [3,5,5]
        Output: false
        Example 3:

        Input: arr = [0,3,2,1]
        Output: true


        Constraints:

        1 <= arr.length <= 10^4
        0 <= arr[i] <= 10^4
    */

    public boolean validMountainArray(int[] arr) {

        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[l] < arr[r]) {
                if (arr[l] >= arr[l + 1]) return false;
                l++;
            } else {
                if (arr[r] >= arr[r - 1]) return false;
                r--;
            }
        }
        return l != 0 && r != arr.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new ValidMountain().validMountainArray(new int[] {0,3,2,1}));
    }
}
