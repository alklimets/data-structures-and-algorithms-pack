package com.aklimets.challenges.neetcode.math.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /*
        Spiral Matrix

        Given an m x n matrix of integers matrix, return a list of all elements within the matrix in spiral order.

        Example 1:
        Input: matrix = [[1,2],[3,4]]

        Output: [1,2,4,3]
        Example 2:



        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]

        Output: [1,2,3,6,9,8,7,4,5]
        Example 3:

        Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]

        Output: [1,2,3,4,8,12,11,10,9,5,6,7]
        Constraints:

        1 <= matrix.length, matrix[i].length <= 10
        -100 <= matrix[i][j] <= 100

    */


    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int i, j;
        while (true) {
            i = top;
            j = left;
            while (j <= right) {
                result.add(matrix[i][j++]);
                if (result.size() == n) return result;
            }
            top++;
            i = top;
            j = right;
            while (i <= bottom) {
                result.add(matrix[i++][j]);
                if (result.size() == n) return result;
            }
            right--;
            i = bottom;
            j = right;
            while (j >= left) {
                result.add(matrix[i][j--]);
                if (result.size() == n) return result;
            }
            bottom--;
            i = bottom;
            j = left;
            while (i >= top) {
                result.add(matrix[i--][j]);
                if (result.size() == n) return result;
            }
            left++;
        }
    }

}
