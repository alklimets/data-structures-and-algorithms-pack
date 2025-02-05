package com.aklimets.data_structures.graphs.leetcode.longest_increasing_path_in_matrix;

import java.util.HashSet;
import java.util.Set;

public class LongestIncreasingPathInMatrix {

    /*
        Given an m x n integers matrix, return the length of the longest increasing path in matrix.
        From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

        Example 1:
        Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
        Output: 4
        Explanation: The longest increasing path is [1, 2, 6, 9].

        Example 2:
        Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
        Output: 4
        Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

        Example 3:
        Input: matrix = [[1]]
        Output: 1

        Constraints:

        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 200
        0 <= matrix[i][j] <= 2^31 - 1
    */

    int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];
        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int length = dfs(matrix, i, j, -1);
                System.out.println(length);
                max = Math.max(max, length);
            }
        }
        return max;
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    int dfs(int[][] matrix, int i, int j, int value) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= value) {
            return 0;
        }
        if (memo[i][j] != 0) return memo[i][j];

        int max = 1;
        for (int[] dir : directions) {
            int length = 1 + dfs(matrix, i + dir[0], j + dir[1], matrix[i][j]);
            max = Math.max(max, length);
        }
        memo[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingPathInMatrix().longestIncreasingPath(new int[][]{
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                {39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
                {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                {59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
                {60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
                {79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
                {80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
                {99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
                {100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
                {119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
                {120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
                {139, 138, 137, 136, 135, 134, 133, 132, 131, 130},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        }));
    }

}
