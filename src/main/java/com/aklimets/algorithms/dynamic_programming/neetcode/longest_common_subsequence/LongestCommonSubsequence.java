package com.aklimets.algorithms.dynamic_programming.neetcode.longest_common_subsequence;

public class LongestCommonSubsequence {


    /*
        Longest Common Subsequence
        Given two strings text1 and text2, return the length of the longest common subsequence between the two strings if one exists, otherwise return 0.

        A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the relative order of the remaining characters.

        For example, "cat" is a subsequence of "crabt".
        A common subsequence of two strings is a subsequence that exists in both strings.

        Example 1:

        Input: text1 = "cat", text2 = "crabt"

        Output: 3
        Explanation: The longest common subsequence is "cat" which has a length of 3.

        Example 2:

        Input: text1 = "abcd", text2 = "abcd"

        Output: 4
        Example 3:

        Input: text1 = "abcd", text2 = "efgh"

        Output: 0
        Constraints:

        1 <= text1.length, text2.length <= 1000
        text1 and text2 consist of only lowercase English characters.
    */

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("aa", "aaa"));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }

}
