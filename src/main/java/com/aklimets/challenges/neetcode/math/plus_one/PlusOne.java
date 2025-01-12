package com.aklimets.challenges.neetcode.math.plus_one;

public class PlusOne {

    /*
        Plus One
        You are given an integer array digits, where each digits[i] is the ith digit of a large integer. It is ordered from most significant to least significant digit, and it will not contain any leading zero.

        Return the digits of the given integer after incrementing it by one.

        Example 1:

        Input: digits = [1,2,3,4]

        Output: [1,2,3,5]
        Explanation 1234 + 1 = 1235.

        Example 2:

        Input: digits = [9,9,9]

        Output: [1,0,0,0]
        Constraints:

        1 <= digits.length <= 100
        0 <= digits[i] <= 9
    */

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
