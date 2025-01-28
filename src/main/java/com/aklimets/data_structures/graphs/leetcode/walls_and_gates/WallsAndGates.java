package com.aklimets.data_structures.graphs.leetcode.walls_and_gates;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    /*
        You are given an m x n grid rooms initialized with these three possible values. -1 A wall or an obstacle.
        0 A gate.
        INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
        Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

        Example 1:
        Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
        Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
        Example 2:

        Input: rooms = [[-1]]
        Output: [[-1]]

        Constraints:

        m == rooms.length
        n == rooms[i].length
        1 <= m, n <= 250
        rooms[i][j] is -1, 0, or 2^31 - 1.
    */

    public void wallsAndGates(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        if (queue.isEmpty()) return;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];

            for (int[] dir : directions) {
                int i = row + dir[0];
                int j = col + dir[1];

                if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] !=2147483647) {
                    continue;
                }
                queue.offer(new int[] {i, j});
                grid[i][j] = grid[row][col] + 1;
            }
        }
    }

    int[][] directions = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
}
