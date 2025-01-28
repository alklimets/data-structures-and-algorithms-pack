package com.aklimets.data_structures.graphs.leetcode.number_of_islands;

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
                    explore(grid, i, j);
                }
            }
        }
        return result;
    }

    private void explore(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;

        grid[i][j] = '0';

        explore(grid, i + 1, j);
        explore(grid, i, j + 1);
        explore(grid, i - 1, j);
        explore(grid, i, j - 1);
    }
}
