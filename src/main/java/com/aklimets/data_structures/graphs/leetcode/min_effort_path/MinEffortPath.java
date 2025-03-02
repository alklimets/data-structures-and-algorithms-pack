package com.aklimets.data_structures.graphs.leetcode.min_effort_path;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinEffortPath {

    /*
        You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
        A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
        Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

        Example 1:
        Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
        Output: 2
        Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
        This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

        Example 2:
        Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
        Output: 1
        Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

        Example 3:
        Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
        Output: 0
        Explanation: This route does not require any effort.

        Constraints:

        rows == heights.length
        columns == heights[i].length
        1 <= rows, columns <= 100
        1 <= heights[i][j] <= 10^6
    */

    public int minimumEffortPath(int[][] heights) {
        int[][] directions = new int[][] { {0,1}, {1, 0}, {-1, 0}, {0, -1}};
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] efforts = new int[rows][cols];
        for (int[] effort : efforts) {
            Arrays.fill(effort, Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;

        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.offer(new int[] {0, 0, 0});

        while (!heap.isEmpty()) {
            int[] poll = heap.poll();

            int effort = poll[0];
            int i = poll[1];
            int j = poll[2];

            if (i == rows - 1 && j == cols - 1) return effort;

            for (int[] dir : directions) {
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if (newI < 0 || newJ < 0 || newI >= rows || newJ >= cols) continue;

                int newEffort = Math.max(effort, Math.abs(heights[i][j] - heights[newI][newJ]));
                if (newEffort < efforts[newI][newJ]) {
                    efforts[newI][newJ] = newEffort;
                    heap.offer(new int[] {newEffort, newI, newJ});
                }
            }
        }

        return 0;
    }
}
