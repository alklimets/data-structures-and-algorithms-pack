package com.aklimets.data_structures.graphs.leetcode.pacific_atlantic_water_flow;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    /*
        There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
        The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
        The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
        Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

        Example 1:
        Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
        Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
        Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
        [0,4]: [0,4] -> Pacific Ocean
               [0,4] -> Atlantic Ocean
        [1,3]: [1,3] -> [0,3] -> Pacific Ocean
               [1,3] -> [1,4] -> Atlantic Ocean
        [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
               [1,4] -> Atlantic Ocean
        [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
               [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
        [3,0]: [3,0] -> Pacific Ocean
               [3,0] -> [4,0] -> Atlantic Ocean
        [3,1]: [3,1] -> [3,0] -> Pacific Ocean
               [3,1] -> [4,1] -> Atlantic Ocean
        [4,0]: [4,0] -> Pacific Ocean
               [4,0] -> Atlantic Ocean
        Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.

        Example 2:
        Input: heights = [[1]]
        Output: [[0,0]]
        Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.

        Constraints:

        m == heights.length
        n == heights[r].length
        1 <= m, n <= 200
        0 <= heights[r][c] <= 10^5
    */

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacificDfs(heights, i, j, 200_000) && atlanticDfs(heights, i, j, 200_000)) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private int[][] directions = {{-1, 0}, {0,-1}, {0, 1}, {1,0}};

    private boolean pacificDfs(int[][] heights, int i, int j, int height) {
        if (i < 0 || j < 0) return true;
        if (i >= heights.length || j >= heights[0].length || heights[i][j] > height) return false;

        int buf = heights[i][j];
        heights[i][j] = 200_000;
        for (int[] dir : directions) {
            if(pacificDfs(heights, i + dir[0], j + dir[1], buf)) {
                heights[i][j] = buf;
                return true;
            }
        }
        heights[i][j] = buf;

        return false;
    }

    private boolean atlanticDfs(int[][] heights, int i, int j, int height) {
        if (i >= heights.length || j >= heights[0].length) return true;
        if (i < 0 || j < 0 || heights[i][j] > height) return false;

        int buf = heights[i][j];
        heights[i][j] = 200_000;
        for (int[] dir : directions) {
            if(atlanticDfs(heights, i + dir[0], j + dir[1], buf)) {
                heights[i][j] = buf;
                return true;
            }
        }
        heights[i][j] = buf;

        return false;
    }






    int ROWS;
    int COLS;

    public List<List<Integer>> pacificAtlantic2(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            dfs(heights, i, 0, pac);
            dfs(heights, i, COLS - 1, atl);
        }

        for (int i = 0; i < COLS; i++) {
            dfs(heights, 0, i, pac);
            dfs(heights, ROWS - 1, i, atl);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] ocean) {
        ocean[i][j] = true;
        for (int[] dir : directions) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii >= 0 && jj >= 0 && ii < ROWS && jj < COLS && heights[ii][jj]>=heights[i][j] && !ocean[ii][jj]) {
                dfs(heights, ii, jj, ocean);
            }
        }
    }
}
