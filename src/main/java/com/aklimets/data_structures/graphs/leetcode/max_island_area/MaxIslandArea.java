package com.aklimets.data_structures.graphs.leetcode.max_island_area;

import java.util.LinkedList;
import java.util.Queue;

public class MaxIslandArea {

    /*
        You are given a matrix grid where grid[i] is either a 0 (representing water) or 1 (representing land).
        An island is defined as a group of 1's connected horizontally or vertically. You may assume all four edges of the grid are surrounded by water.
        The area of an island is defined as the number of cells within the island.
        Return the maximum area of an island in grid. If no island exists, return 0.

        Example 1:
        Input: grid = [
          [0,1,1,0,1],
          [1,0,1,0,1],
          [0,1,1,0,1],
          [0,1,0,0,1]
        ]

        Output: 6
        Explanation: 1's cannot be connected diagonally, so the maximum area of the island is 6.

        Constraints:

        1 <= grid.length, grid[i].length <= 50
    */

    private int[][] directions = {{0,1}, {1,0}, {-1, 0}, {0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, exploreBfs(grid, i, j));
                }
            }
        }
        return max;
    }

    private int exploreBfs(int[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        grid[i][j] = 0;
        int area = 0;
        while (!queue.isEmpty()) {
            area++;
            int[] poll = queue.poll();
            int ii = poll[0], jj = poll[1];
            for (int[] dir : directions) {
                int newI = ii + dir[0];
                int newJ = jj + dir[1];
                if (newI >= 0 && newJ >= 0 && newI < grid.length && newJ < grid[0].length && grid[newI][newJ] == 1) {
                    queue.offer(new int[]{newI, newJ});
                    grid[newI][newJ] = 0;
                }
            }

        }
        return area;
    }

    private int exploreDfs(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;
        int area = 1;
        grid[i][j] = 0;
        for (int[] dir : directions) {
            area += exploreDfs(grid, i + dir[0], j + dir[1]);
        }
        return area;
    }
}
