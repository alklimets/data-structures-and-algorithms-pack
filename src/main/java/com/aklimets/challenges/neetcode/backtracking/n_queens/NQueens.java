package com.aklimets.challenges.neetcode.backtracking.n_queens;

import java.util.*;

public class NQueens {
    /*
        The n-queens puzzle is the problem of placing n queens on an n x n chessboard so that no two queens can attack each other.
        A queen in a chessboard can attack horizontally, vertically, and diagonally.
        Given an integer n, return all distinct solutions to the n-queens puzzle.
        Each solution contains a unique board layout where the queen pieces are placed. 'Q' indicates a queen and '.' indicates an empty space.
        You may return the answer in any order.

        Example 1:
        Input: n = 4
        Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        Explanation: There are two different solutions to the 4-queens puzzle.

        Example 2:
        Input: n = 1
        Output: [["Q"]]

        Constraints:

        1 <= n <= 8

    */

    List<List<String>> res = new ArrayList<>();
    Set<Integer> columns = new HashSet<>();
    Set<Integer> leftDiagonal = new HashSet<>();
    Set<Integer> rightDiagonal = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 1) return List.of(List.of("Q"));
        if (n == 2 || n == 3) return List.of();
        dfs(n, 0, new LinkedList<>());
        return res;
    }

    public void dfs(int n, int row, LinkedList<Integer> current) {
        if (current.size() == n) {
            construct(n, current);
            return;
        }

        for (int i = 0; i < n; i++) {
            int leftD = n - 1 - row + i;
            int rightD = row + i;
            if (!columns.contains(i) && !leftDiagonal.contains(leftD) && !rightDiagonal.contains(rightD)) {
                current.add(i);
                columns.add(i);
                leftDiagonal.add(leftD);
                rightDiagonal.add(rightD);
                dfs(n, row + 1, current);
                current.removeLast();
                columns.remove(i);
                leftDiagonal.remove(leftD);
                rightDiagonal.remove(rightD);
            }
        }
    }

    private void construct(int n, LinkedList<Integer> queens) {
        List<String> combined = new ArrayList<>();
        for (int queen : queens) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(i == queen ? 'Q' : ". ");
            }
            combined.add(sb.toString());
        }
        res.add(combined);
    }


    // a bit faster solution
    public List<List<String>> solveNQueens2(int n) {
        if (n == 1) return List.of(List.of("Q"));
        if (n == 2 || n == 3) return List.of();
        char[][] board = new char[n][n];
        for (char[] b : board) {
            Arrays.fill(b, '.');
        }
        dfs2(n, 0, board);
        return res;
    }

    public void dfs2(int n, int row, char[][] board) {
        if (row == n) {
            // construct(n, current);
            List<String> combine = new ArrayList<>();
            for (char[] b : board) {
                combine.add(new String(b));
            }
            res.add(combine);
            return;
        }

        for (int i = 0; i < n; i++) {
            int leftD = n - 1 - row + i;
            int rightD = row + i;
            if (!columns.contains(i) && !leftDiagonal.contains(leftD) && !rightDiagonal.contains(rightD)) {
                board[row][i] = 'Q';
                columns.add(i);
                leftDiagonal.add(leftD);
                rightDiagonal.add(rightD);
                dfs2(n, row + 1, board);
                board[row][i] = '.';
                columns.remove(i);
                leftDiagonal.remove(leftD);
                rightDiagonal.remove(rightD);
            }
        }
    }

    public static void main(String[] args) {
        new NQueens().solveNQueens(5).forEach(i -> {
            i.forEach(System.out::println);
            System.out.println();
        });
    }
}
