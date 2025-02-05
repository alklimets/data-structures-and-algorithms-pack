package com.aklimets.challenges.leetcode.reverse_number;

public class ReverseNumber {

    /*
        Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
        Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

        Example 1:
        Input: x = 123
        Output: 321

        Example 2:
        Input: x = -123
        Output: -321

        Example 3:
        Input: x = 120
        Output: 21

        Constraints:

        -2^31 <= x <= 2^31 - 1
    */

    public int reverse(int x) {
        if (x == 0) return 0;
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);

        int number = 0, mult = 10;
        while (x % 10 == 0) {
            x /= 10;
        }
        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < number) return 0;
            int num = x % 10;
            number *= mult;
            number += num;
            x /= 10;
        }

        return number * sign;
    }
}
