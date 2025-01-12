package com.aklimets.challenges.neetcode.math.rotate_image;

public class RotateImage {

    /*
        Rotate Image
        Given a square n x n matrix of integers matrix, rotate it by 90 degrees clockwise.

        You must rotate the matrix in-place. Do not allocate another 2D matrix and do the rotation.

        Example 1:
        Input: matrix = [
          [1,2],
          [3,4]
        ]

        Output: [
          [3,1],
          [4,2]
        ]
        Example 2:
        Input: matrix = [
          [1,2,3],
          [4,5,6],
          [7,8,9]
        ]
    */

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int buff = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - i - 1][n - 1 - j];
                matrix[n - i - 1][n - 1 - j] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = buff;
            }
        }
    }
}
