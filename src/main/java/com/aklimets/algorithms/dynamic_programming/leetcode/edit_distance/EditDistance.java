package com.aklimets.algorithms.dynamic_programming.leetcode.edit_distance;

public class EditDistance {

    /*
        Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
        You have the following three operations permitted on a word:

        Insert a character
        Delete a character
        Replace a character

        Example 1:
        Input: word1 = "horse", word2 = "ros"
        Output: 3
        Explanation:
        horse -> rorse (replace 'h' with 'r')
        rorse -> rose (remove 'r')
        rose -> ros (remove 'e')

        Example 2:
        Input: word1 = "intention", word2 = "execution"
        Output: 5
        Explanation:
        intention -> inention (remove 't')
        inention -> enention (replace 'i' with 'e')
        enention -> exention (replace 'n' with 'x')
        exention -> exection (replace 'n' with 'c')
        exection -> execution (insert 'u')

        Constraints:

        0 <= word1.length, word2.length <= 500
        word1 and word2 consist of lowercase English letters.
    */

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp = new int[w1.length + 1][w2.length + 1];
        for (int i = 1; i <= w2.length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= w1.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= w1.length; i++) {
            for (int j = 1; j <= w2.length; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[w1.length][w2.length];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("money", "monkeys"));
    }
}
