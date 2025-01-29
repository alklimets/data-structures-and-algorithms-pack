package com.aklimets.data_structures.graphs.leetcode.rotting_fruits;

import java.util.LinkedList;
import java.util.Queue;

public class RottingFruits {

    /*
        You are given an m x n grid where each cell can have one of three values:

        0 representing an empty cell,
        1 representing a fresh orange, or
        2 representing a rotten orange.
        Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
        Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

        Example 1:
        Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
        Output: 4

        Example 2:
        Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
        Output: -1
        Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

        Example 3:
        Input: grid = [[0,2]]
        Output: 0
        Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

        Constraints:

        m == grid.length
        n == grid[i].length
        1 <= m, n <= 10
        grid[i][j] is 0, 1, or 2.
    */

    public int orangesRotting(int[][] grid) {
        int freshCount = 0, minutes = 0;
        Queue<int[]> rotten = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    rotten.offer(new int[] {i, j, 0});
                }
            }
        }
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while (!rotten.isEmpty()) {
            int[] poll = rotten.poll();
            int i = poll[0];
            int j = poll[1];
            int minute = poll[2];
            minutes = Math.max(minutes, minute);
            for (int[] dir : directions) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && jj >= 0 &&  ii < grid.length && jj < grid[0].length && grid[ii][jj] == 1) {
                    freshCount--;
                    rotten.offer(new int[] {ii, jj, minute + 1});
                    grid[ii][jj] = 2;
                }
            }
        }

        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        System.out.println(new RottingFruits().orangesRotting(new int[][] {{1,1,0}, {0,1,1}, {0,1,2}}));
    }
}
