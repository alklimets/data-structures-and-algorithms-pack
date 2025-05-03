package com.aklimets.data_structures.graphs.leetcode.min_cost_connected;

import java.util.Arrays;

public class MinCostConnected {

    /*
        You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
        The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|,
         where |val| denotes the absolute value of val.
        Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

        Example 1:
        Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
        Output: 20
        Explanation:
        We can connect the points as shown above to get the minimum cost of 20.
        Notice that there is a unique path between every pair of points.

        Example 2:
        Input: points = [[3,12],[-2,5],[-4,1]]
        Output: 18

        Constraints:

        1 <= points.length <= 1000
        -10^6 <= xi, yi <= 10^6
        All pairs (xi, yi) are distinct.
    */

    public int minCostConnectPoints(int[][] points) {
        int size = points.length, node = 0;
        int[] distances = new int[size];
        boolean[] visited = new boolean[size];
        Arrays.fill(distances, Integer.MAX_VALUE);

        int edges = 0, result = 0;

        while (edges < size - 1) {
            visited[node] = true;
            int nextNode = -1;
            for (int i = 0; i < size; i++) {
                if (visited[i]) continue;
                int dist = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);
                distances[i] = Math.min(distances[i], dist);
                if (nextNode == -1 || distances[i] < distances[nextNode]) {
                    nextNode = i;
                }
            }
            result += distances[nextNode];
            node = nextNode;
            edges++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MinCostConnected().minCostConnectPoints(new int[][] {{0,0},{2,2},{3,10},{5,2},{7,0}}));
    }
}
