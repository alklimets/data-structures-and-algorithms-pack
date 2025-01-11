package com.aklimets.data_structures.arrays.leetcode.duplicate_zeros;

import java.util.Arrays;

public class DuplicateZeros {

    /*
        Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

        Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.



        Example 1:

        Input: arr = [1,0,2,3,0,4,5,0]
        Output: [1,0,0,2,3,0,0,4]
        Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
        Example 2:

        Input: arr = [1,2,3]
        Output: [1,2,3]
        Explanation: After calling your function, the input array is modified to: [1,2,3]


        Constraints:

        1 <= arr.length <= 104
        0 <= arr[i] <= 9
    */

    public int[] duplicateZeros(int[] arr) {
        int countZeros = 0;
        int lastZeroIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && i + countZeros + 1 < arr.length) {
                countZeros++;
                lastZeroIndex = i;
            }
        }

        for (int i = arr.length - countZeros - 1; i >= 0; i--) {
            if (arr[i] != 0 || i > lastZeroIndex) {
                arr[i + countZeros] = arr[i];
            } else {
                arr[i + countZeros--] = 0;
                arr[i + countZeros] = 0;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DuplicateZeros().duplicateZeros(new int[]{1, 5, 2, 0, 6, 8, 0, 6, 0})));
    }
}
