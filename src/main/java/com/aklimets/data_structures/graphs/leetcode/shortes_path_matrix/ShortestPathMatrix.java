package com.aklimets.data_structures.graphs.leetcode.shortes_path_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathMatrix {

    /*
        Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
        A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

        All the visited cells of the path are 0.
        All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
        The length of a clear path is the number of visited cells of this path.

        Example 1:
        Input: grid = [[0,1],[1,0]]
        Output: 2

        Example 2:
        Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
        Output: 4

        Example 3:
        Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
        Output: -1

        Constraints:

        n == grid.length
        n == grid[i].length
        1 <= n <= 100
        grid[i][j] is 0 or 1
    */

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) return -1;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = new int[][] {{1,0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1,-1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        grid[0][0] = 1;

        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            for (int q = queue.size(); q > 0; q--) {
                int[] polled = queue.poll();
                int i = polled[0];
                int j = polled[1];

                if (i == rows - 1 && j == cols - 1) return steps;

                for (int[] dir : dirs) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];

                    if (ii >= 0 && jj >= 0 && ii < rows && jj < cols && grid[ii][jj] == 0) {
                        queue.offer(new int[]{ii, jj});
                        grid[ii][jj] = 1;
                    }
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestPathMatrix().shortestPathBinaryMatrix(new int[][]{{0,0,0}, {1,1,0}, {1,1,0}}));
    }
}
