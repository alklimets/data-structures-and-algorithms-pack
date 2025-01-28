package com.aklimets.challenges.neetcode.backtracking.n_queens_2;

public class NQueens2 {

    /*
        The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
        Given an integer n, return the number of distinct solutions to the n-queens puzzle.
        Example 1:

        Input: n = 4
        Output: 2
        Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
        Example 2:
        Input: n = 1
        Output: 1

        Constraints:

        1 <= n <= 9
    */

    int res = 0;
    boolean[] columns;
    boolean[] leftDiagonal;
    boolean[] rightDiagonal;

    public int totalNQueens(int n) {
        columns = new boolean[n];
        leftDiagonal = new boolean[2*n];
        rightDiagonal = new boolean[2*n];
        if (n == 1) return 1;
        if (n == 2 || n == 3) return 0;
        dfs(n, 0);
        return res;
    }

    public void dfs(int n, int row) {
        if (row == n) {
            res++;
        }

        for (int i = 0; i < n; i++) {
            int leftD = n - 1 - row + i;
            int rightD = row + i;
            if (!columns[i] && !leftDiagonal[leftD] && !rightDiagonal[rightD]) {
                columns[i] = true;
                leftDiagonal[leftD] = true;
                rightDiagonal[rightD] = true;
                dfs(n, row + 1);
                columns[i] = false;
                leftDiagonal[leftD] = false;
                rightDiagonal[rightD] = false;
            }
        }
    }
}
