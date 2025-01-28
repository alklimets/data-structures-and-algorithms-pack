package com.aklimets.data_structures.graphs.leetcode.number_of_islands;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {

    /*
        Given a 2D grid grid where '1' represents land and '0' represents water, count and return the number of islands.
        An island is formed by connecting adjacent lands horizontally or vertically and is surrounded by water. You may assume water is surrounding the grid (i.e., all the edges are water).
        Example 1:

        Input: grid = [
            ["0","1","1","1","0"],
            ["0","1","0","1","0"],
            ["1","1","0","0","0"],
            ["0","0","0","0","0"]
          ]
        Output: 1
        Example 2:

        Input: grid = [
            ["1","1","0","0","1"],
            ["1","1","0","0","1"],
            ["0","0","1","0","0"],
            ["0","0","0","1","1"]
          ]
        Output: 4

        Constraints:

        1 <= grid.length, grid[i].length <= 100
        grid[i][j] is '0' or '1'.
    */

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    exploreBfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void exploreDfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;

        grid[i][j] = '0';

        exploreDfs(grid, i + 1, j);
        exploreDfs(grid, i, j + 1);
        exploreDfs(grid, i - 1, j);
        exploreDfs(grid, i, j - 1);
    }

    List<int[]> directions = List.of(new int[]{1,0}, new int[]{0,1}, new int[]{-1,0}, new int[]{0,-1});

    private void exploreBfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int ii = poll[0], jj = poll[1];
            grid[ii][jj] = '0';
            for (int[] dir : directions) {
                int newI = ii + dir[0];
                int newJ = jj + dir[1];
                if (newI >= 0 && newJ >= 0 && newI < grid.length && newJ < grid[0].length && grid[newI][newJ] == '1') {
                    queue.offer(new int[]{newI, newJ});
                }
            }

        }
    }
}
