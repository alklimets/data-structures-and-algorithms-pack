package com.aklimets.challenges.neetcode.bit_manipulation.reverse_integer;

public class ReverseInteger {

    /*
        Reverse Integer
        You are given a signed 32-bit integer x.

        Return x after reversing each of its digits. After reversing, if x goes outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0 instead.

        Solve the problem without using integers that are outside the signed 32-bit integer range.

        Example 1:

        Input: x = 1234

        Output: 4321
        Example 2:

        Input: x = -1234

        Output: -4321
        Example 3:

        Input: x = 1234236467

        Output: 0
        Constraints:

        -2^31 <= x <= 2^31 - 1
    */

    public int reverse(int x) {
        boolean isNegative = x < 0;
        if (isNegative) x *= -1;
        int[] nums = new int[32];
        int index = 0;
        while (x > 0) {
            int digit = x % 10;
            nums[index++] = digit;
            x /= 10;
        }

        int result = 0;
        for (int i = 0; i < index; i++) {
            int oldResult = result;
            result *= 10;
            result += nums[i];
            if (oldResult != result / 10) return 0;
        }
        return isNegative ? -result : result;

    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1534236469));
    }
}
