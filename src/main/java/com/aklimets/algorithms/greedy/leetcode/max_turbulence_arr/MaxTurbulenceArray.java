package com.aklimets.algorithms.greedy.leetcode.max_turbulence_arr;

public class MaxTurbulenceArray {

    /*
        Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
        A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
        More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

        For i <= k < j:
        arr[k] > arr[k + 1] when k is odd, and
        arr[k] < arr[k + 1] when k is even.
        Or, for i <= k < j:
        arr[k] > arr[k + 1] when k is even, and
        arr[k] < arr[k + 1] when k is odd.

        Example 1:
        Input: arr = [9,4,2,10,7,8,8,1,9]
        Output: 5
        Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]

        Example 2:
        Input: arr = [4,8,12,16]
        Output: 2

        Example 3:
        Input: arr = [100]
        Output: 1
    */

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) return arr.length;
        int max = 1;
        int current = 1;
        int sign = 0;
        for (int i = 1; i < arr.length; i++) {
            int currentSign = Integer.compare(arr[i], arr[i - 1]);
            if (currentSign * sign < 0) {
                current++;
            } else {
                current = currentSign != 0 ? 2 : 1;
            }
            max = Math.max(max, current);
            sign = currentSign;

        }
        return max;
    }
}
