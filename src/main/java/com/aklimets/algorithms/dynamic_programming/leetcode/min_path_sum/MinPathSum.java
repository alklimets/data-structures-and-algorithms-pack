package com.aklimets.algorithms.dynamic_programming.leetcode.min_path_sum;

import java.util.Arrays;

public class MinPathSum {

    /*
        Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
        Note: You can only move either down or right at any point in time.

        Example 1:
        Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
        Output: 7
        Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

        Example 2:
        Input: grid = [[1,2,3],[4,5,6]]
        Output: 12

        Constraints:

        m == grid.length
        n == grid[i].length
        1 <= m, n <= 200
        0 <= grid[i][j] <= 200
    */

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m + 1][n + 1];
        for (int[] row : matrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        matrix[m][n - 1] = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                matrix[i][j] = grid[i][j] + Math.min(matrix[i + 1][j], matrix[i][j + 1]);
            }
        }
        return matrix[0][0];
    }
}
