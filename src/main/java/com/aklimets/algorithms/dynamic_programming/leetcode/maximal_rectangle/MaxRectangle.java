package com.aklimets.algorithms.dynamic_programming.leetcode.maximal_rectangle;

import java.util.Stack;

public class MaxRectangle {

    /*
        Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

        Example 1:
        Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        Output: 6
        Explanation: The maximal rectangle is shown in the above picture.

        Example 2:
        Input: matrix = [["0"]]
        Output: 0

        Example 3:
        Input: matrix = [["1"]]
        Output: 1

        Constraints:

        rows == matrix.length
        cols == matrix[i].length
        1 <= row, cols <= 200
        matrix[i][j] is '0' or '1'.
    */

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] histogram = new int[cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    histogram[j]++;
                } else {
                    histogram[j] = 0;
                }
            }

            max = Math.max(max, calculateHistogram(histogram));
        }
        return max;
    }

    int calculateHistogram(int[] histogram) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= histogram.length; i++) {
            while (!stack.isEmpty() && (i == histogram.length || histogram[stack.peek()] >= histogram[i])) {
                int index = stack.pop();
                int length = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(histogram[index] * length, max);
            }
            stack.push(i);
        }
        return max;
    }
}
