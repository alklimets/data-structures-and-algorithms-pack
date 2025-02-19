package com.aklimets.challenges.neetcode.backtracking.sudoku_solver;

import java.util.*;

public class SudokuSolver {

    /*
        Write a program to solve a Sudoku puzzle by filling the empty cells.
        A sudoku solution must satisfy all of the following rules:

        Each of the digits 1-9 must occur exactly once in each row.
        Each of the digits 1-9 must occur exactly once in each column.
        Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
        The '.' character indicates empty cells.

        Example 1:
        Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
        Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
        Explanation: The input board is shown above and the only valid solution is shown below:

        Constraints:

        board.length == 9
        board[i].length == 9
        board[i][j] is a digit or '.'.
        It is guaranteed that the input board has only one solution.
    */

    List<Set<Character>> rows = new ArrayList<>();
    List<Set<Character>> cols = new ArrayList<>();
    List<Set<Character>> squares = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            squares.add(new HashSet<>());
        }
        int filled = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rows.get(i).add(board[i][j]);
                    cols.get(j).add(board[i][j]);

                    int r = i / 3;
                    int c = j / 3;
                    squares.get(3 * r + c).add(board[i][j]);
                    filled++;
                }
            }
        }

        backtrack(board, filled);
    }

    boolean backtrack(char[][] board, int filled) {
        if (filled == 81) return true;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k++) {
                        int r = i / 3;
                        int c = j / 3;
                        int sq = 3 * r + c;
                        char ch = (char) (k + '0');
                        if (!rows.get(i).contains(ch) && !cols.get(j).contains(ch) && !squares.get(sq).contains(ch)) {
                            board[i][j] = ch;
                            rows.get(i).add(ch);
                            cols.get(j).add(ch);
                            squares.get(sq).add(ch);
                            if (backtrack(board, filled + 1)) {
                                return true;
                            }
                            board[i][j] = '.';
                            rows.get(i).remove(ch);
                            cols.get(j).remove(ch);
                            squares.get(sq).remove(ch);
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        for (char[] b : board) {
            System.out.println(Arrays.toString(b));
        }
        new SudokuSolver().solveSudoku(board);
        for (char[] b : board) {
            System.out.println(Arrays.toString(b));
        }
    }
}
