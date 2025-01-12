package com.aklimets.challenges.neetcode.math.set_zeros;

public class SetZeros {

    /*
        Set Matrix Zeroes

        Given an m x n matrix of integers matrix, if an element is 0, set its entire row and column to 0's.

        You must update the matrix in-place.

        Follow up: Could you solve it using O(1) space?

        Example 1:

        Input: matrix = [
          [0,1],
          [1,1]
        ]

        Output: [
          [0,0],
          [0,1]
        ]
        Example 2:

        Input: matrix = [
          [1,2,3],
          [4,0,5],
          [6,7,8]
        ]

        Output: [
          [1,0,3],
          [0,0,0],
          [6,0,8]
        ]
        Constraints:

        1 <= matrix.length, matrix[0].length <= 100
        -2^31 <= matrix[i][j] <= (2^31) - 1

    */

    public void setZeroes(int[][] matrix) {
        boolean topZeros = false, leftZeros = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) topZeros = true;
                    if (j == 0) leftZeros = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (leftZeros) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (topZeros) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
