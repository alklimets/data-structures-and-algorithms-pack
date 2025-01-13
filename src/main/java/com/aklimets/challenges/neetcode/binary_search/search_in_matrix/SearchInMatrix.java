package com.aklimets.challenges.neetcode.binary_search.search_in_matrix;

public class SearchInMatrix {

    /*
        Search a 2D Matrix
        You are given an m x n 2-D integer array matrix and an integer target.

        Each row in matrix is sorted in non-decreasing order.
        The first integer of every row is greater than the last integer of the previous row.
        Return true if target exists within matrix or false otherwise.

        Can you write a solution that runs in O(log(m * n)) time?

        Example 1:
        Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10

        Output: true
        Example 2:
        Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15

        Output: false
        Constraints:

        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 100
        -10000 <= matrix[i][j], target <= 10000
    */

    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (top < bottom) {
            int middle = top + (bottom - top) / 2;
            if (target <= matrix[middle][right] && target >= matrix[middle][left]) {
                top = middle;
                break;
            }
            if (target < matrix[middle][left]) {
                bottom = middle - 1;
            } else {
                top = middle + 1;
            }
        }
        if (target <= matrix[top][right] && target >= matrix[top][left]) {
            while (left < right) {
                int midCol = left + (right - left) / 2;
                if (matrix[top][midCol] == target) {
                    return true;
                }
                if (matrix[top][midCol] > target) {
                    right = midCol - 1;
                } else {
                    left = midCol + 1;
                }
            }
        }

        return matrix[top][left] == target;
    }
}
