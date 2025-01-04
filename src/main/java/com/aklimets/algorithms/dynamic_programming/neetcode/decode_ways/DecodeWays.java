package com.aklimets.algorithms.dynamic_programming.neetcode.decode_ways;

public class DecodeWays {

    /*
        Decode Ways
        A string consisting of uppercase english characters can be encoded to a number using the following mapping:

        'A' -> "1"
        'B' -> "2"
        ...
        'Z' -> "26"
        To decode a message, digits must be grouped and then mapped back into letters using the reverse of the mapping above. There may be multiple ways to decode a message. For example, "1012" can be mapped into:

        "JAB" with the grouping (10 1 2)
        "JL" with the grouping (10 12)
        The grouping (1 01 2) is invalid because 01 cannot be mapped into a letter since it contains a leading zero.

        Given a string s containing only digits, return the number of ways to decode it. You can assume that the answer fits in a 32-bit integer.

        Example 1:

        Input: s = "12"

        Output: 2

        Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
        Example 2:

        Input: s = "01"

        Output: 0
        Explanation: "01" cannot be decoded because "01" cannot be mapped into a letter.

        Constraints:

        1 <= s.length <= 100
        s consists of digits
        */

    public int numDecodings(String s) {
        return numDecodings(s, 0);
    }

    public int numDecodings(String s, int index) {
        String substring = s.substring(index);
        if (substring.length() <= 1) return validateNum(substring) ? 1 : 0;
        if (substring.length() == 2) {
            int res = validateNum(substring) ? 1 : 0;
            if (substring.charAt(0) != '0' && Integer.parseInt(substring) % 10 != 0) {
                res++;
            }
            return res;
        }
        int one = 0, two = 0;
        String small = substring.substring(0, 1);
        String large = substring.substring(0, 2);
        if (validateNum(small)) {
            one = numDecodings(substring, 1);
        }
        if (validateNum(large)) {
            two = numDecodings(substring, 2);
        }
        return one + two;
    }

    private boolean validateNum(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return false;
        return Integer.parseInt(s) < 27;
    }


    // DP
    public int numDecodingsDP(String s) {
        int[] memo = new int[s.length() + 1];
        memo[memo.length - 1] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                memo[i] = 0;
            } else {
                memo[i] = memo[i + 1];
                if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                    memo[i] += memo[i + 2];
                }
            }
        }

        return memo[0];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodingsDP("10123"));
    }

}
