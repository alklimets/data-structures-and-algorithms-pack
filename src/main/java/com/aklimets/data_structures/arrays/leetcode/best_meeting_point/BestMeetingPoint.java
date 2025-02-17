package com.aklimets.data_structures.arrays.leetcode.best_meeting_point;

import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint {

    /*
        Problem: "Best Meeting Point" (Hard)
        (Variation of LeetCode #296 - "Best Meeting Point")

        Description:
        You are given an m x n binary grid, where:

        1 represents a person.
        0 represents an empty space.
        A meeting point is a location (x, y) where total travel distance for all people is minimized.
        The total distance is calculated as Manhattan Distance:

        Find the minimum total travel distance to the best meeting point.

        Constraints:
        1 <= m, n <= 200
        grid[i][j] is either 0 or 1.
        There is at least one 1 in the grid.
    */

    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        rows.sort(Integer::compareTo);
        cols.sort(Integer::compareTo);

        int rowMedian = rows.get(rows.size() / 2);
        int colMedian = cols.get(cols.size() / 2);

        return getDistance(rows, rowMedian) + getDistance(cols, colMedian);
    }

    private int getDistance(List<Integer> values, int median) {
        return values.stream().map(value -> Math.abs(value - median)).reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println(new BestMeetingPoint().minTotalDistance(new int[][]{
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1}
        }));
    }
}
