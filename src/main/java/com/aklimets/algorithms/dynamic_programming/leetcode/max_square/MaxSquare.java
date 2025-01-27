package com.aklimets.algorithms.dynamic_programming.leetcode.max_square;

public class MaxSquare {

    /*
        Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

        Example 1:
        Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        Output: 4

        Example 2:
        Input: matrix = [["0","1"],["1","0"]]
        Output: 1

        Example 3:
        Input: matrix = [["0"]]
        Output: 0

        Constraints:

        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 300
        matrix[i][j] is '0' or '1'.
    */

    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i-1][j-1]) + 1;
                    max = Math.max(max, dp[i][j] * dp[i][j]);
                }
            }
        }
        return max;
    }
}
