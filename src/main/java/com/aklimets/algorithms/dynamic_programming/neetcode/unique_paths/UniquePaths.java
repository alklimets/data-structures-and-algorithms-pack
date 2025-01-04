package com.aklimets.algorithms.dynamic_programming.neetcode.unique_paths;

public class UniquePaths {

    /*
        Unique Paths
        There is an m x n grid where you are allowed to move either down or to the right at any point in time.

        Given the two integers m and n, return the number of possible unique paths that can be taken from the top-left corner of the grid (grid[0][0]) to the bottom-right corner (grid[m - 1][n - 1]).

        You may assume the output will fit in a 32-bit integer.

        Example 1:
        Input: m = 3, n = 6
        Output: 21

        Example 2:
        Input: m = 3, n = 3
        Output: 6

        Constraints:

        1 <= m, n <= 100
    */

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m + 1][n + 1];
        matrix[m][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                matrix[i][j] = matrix[i][j + 1] + matrix[i + 1][j];
            }
        }

        return matrix[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3,3));
    }
}
