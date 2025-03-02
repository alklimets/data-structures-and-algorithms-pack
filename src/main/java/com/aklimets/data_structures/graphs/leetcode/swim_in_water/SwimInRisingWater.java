package com.aklimets.data_structures.graphs.leetcode.swim_in_water;

import java.util.PriorityQueue;
import java.util.Queue;

public class SwimInRisingWater {
    /*
        You are given a square 2-D matrix of distinct integers grid where each integer grid[i][j] represents the elevation at position (i, j).
        Rain starts to fall at time = 0, which causes the water level to rise. At time t, the water level across the entire grid is t.
        You may swim either horizontally or vertically in the grid between two adjacent squares if the original elevation of both squares is less than or equal to the water level at time t.
        Starting from the top left square (0, 0), return the minimum amount of time it will take until it is possible to reach the bottom right square (n - 1, n - 1).

        Example 1:
        Input: grid = [[0,1],[2,3]]
        Output: 3
        Explanation: For a path to exist to the bottom right square grid[1][1] the water elevation must be at least 3. At time t = 3, the water level is 3.

        Example 2:

        Input: grid = [
          [0,1,2,10],
          [9,14,4,13],
          [12,3,8,15],
          [11,5,7,6]]
        ]

        Output: 8
        Explanation: The water level must be at least 8 to reach the bottom right square. The path is [0, 1, 2, 4, 8, 7, 6].

        Constraints:

        grid.length == grid[i].length
        1 <= grid.length <= 50
        0 <= grid[i][j] < n^2
    */

    public int swimInWater(int[][] grid) {
        int size = grid.length;

        boolean[][] visited = new boolean[size][size];

        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.offer(new int[] {grid[0][0], 0, 0});
        int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1, 0}};
        while (!heap.isEmpty()) {
            int[] current = heap.poll();

            int time = current[0];
            int i = current[1];
            int j = current[2];

            if (i == size - 1 && j == size - 1) return time;

            for (int[] dir : directions) {
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if (newI < 0 || newJ < 0 || newI >= size || newJ >= size || visited[newI][newJ]) {
                    continue;
                }
                visited[newI][newJ] = true;
                heap.offer(new int[] {Math.max(time, grid[newI][newJ]), newI, newJ});
            }

        }

        return -1;
    }
}
