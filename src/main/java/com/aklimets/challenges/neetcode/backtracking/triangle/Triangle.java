package com.aklimets.challenges.neetcode.backtracking.triangle;

import java.util.Arrays;
import java.util.List;

public class Triangle {

    /*
        Given a triangle array, return the minimum path sum from top to bottom.
        For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

        Example 1:
        Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        Output: 11
        Explanation: The triangle looks like:
           2
          3 4
         6 5 7
        4 1 8 3
        The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

        Example 2:
        Input: triangle = [[-10]]
        Output: -10

        Constraints:

        1 <= triangle.length <= 200
        triangle[0].length == 1
        triangle[i].length == triangle[i - 1].length + 1
        -10^4 <= triangle[i][j] <= 10^4
    */

    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new int[triangle.size()][triangle.size()];
        for (int[] mem : memo) {
            Arrays.fill(mem, Integer.MAX_VALUE);
        }
        return backtrack(triangle, 0, 0);
    }

    int[][] memo;

    private int backtrack(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) return 0;

        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }

        int min = triangle.get(i).get(j) + Math.min(backtrack(triangle, i + 1, j), backtrack(triangle, i + 1, j + 1));
        memo[i][j] = min;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Triangle().minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
    }
}
