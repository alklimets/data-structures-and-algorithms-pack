package com.aklimets.data_structures.heaps.k_closest_to_origin;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestToOrigin {

    /*
        You are given an 2-D array points where points[i] = [xi, yi] represents the coordinates of a point on an X-Y axis plane. You are also given an integer k.
        Return the k closest points to the origin (0, 0).
        The distance between two points is defined as the Euclidean distance (sqrt((x1 - x2)^2 + (y1 - y2)^2)).
        You may return the answer in any order.

        Example 1:
        Input: points = [[0,2],[2,2]], k = 1
        Output: [[0,2]]
        Explanation : The distance between (0, 2) and the origin (0, 0) is 2. The distance between (2, 2) and the origin is sqrt(2^2 + 2^2) = 2.82842. So the closest point to the origin is (0, 2).

        Example 2:
        Input: points = [[0,2],[2,0],[2,2]], k = 2
        Output: [[0,2],[2,0]]
        Explanation: The output [2,0],[0,2] would also be accepted.

        Constraints:

        1 <= k <= points.length <= 1000
        -100 <= points[i][0], points[i][1] <= 100
    */

    static class Pair {
        int[] points;
        double distance;

        double getDistance() {
            return distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        Queue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingDouble(Pair::getDistance));
        for (int[] point : points) {
            double distance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            Pair pair = new Pair();
            pair.points = point;
            pair.distance = distance;
            minHeap.offer(pair);
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().points;
        }
        return result;
    }

    public int[][] kClosest2(int[][] points, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
        });
        for (int[] point : points) {
            minHeap.offer(point);
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
