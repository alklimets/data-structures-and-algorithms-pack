package com.aklimets.data_structures.graphs.leetcode.surrounded_regions;

import java.util.Arrays;

public class SurroundedRegions {

    /*
        You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
        Connect: A cell is connected to adjacent cells horizontally or vertically.
        Region: To form a region connect every 'O' cell.
        Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
        To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

        Example 1:
        Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
        Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
        Explanation:
        In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

        Example 2:
        Input: board = [["X"]]
        Output: [["X"]]

        Constraints:

        m == board.length
        n == board[i].length
        1 <= m, n <= 200
        board[i][j] is 'X' or 'O'.
    */

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }

        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[rows - 1][i] == 'O') {
                dfs(board, rows - 1, i);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'Q') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }


    int[][] directions = {{1,0}, {0,1}, {-1, 0}, {0, -1}};

    void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'Q';
        for (int[] dir : directions) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            dfs(board, ii, jj);
        }
    }
}
