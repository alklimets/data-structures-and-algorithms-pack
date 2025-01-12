package com.aklimets.challenges.neetcode.bit_manipulation.count_bits;

public class CountBits {

    /*
        Counting Bits
        Given an integer n, count the number of 1's in the binary representation of every number in the range [0, n].

        Return an array output where output[i] is the number of 1's in the binary representation of i.

        Example 1:

        Input: n = 4

        Output: [0,1,1,2,1]
        Explanation:
        0 --> 0
        1 --> 1
        2 --> 10
        3 --> 11
        4 --> 100

        Constraints:

        0 <= n <= 1000
    */

    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int num = i;
            int count = 0;
            while (num > 0) {
                if (num % 2 == 1) {
                    count++;
                }
                num >>= 1;
            }
            result[i] = count;
        }
        return result;
    }
}
