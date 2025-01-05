package com.aklimets.data_structures.arrays.neetcode.valid_sudoku;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    /*
        You are given a a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:

        Each row must contain the digits 1-9 without duplicates.
        Each column must contain the digits 1-9 without duplicates.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
        Return true if the Sudoku board is valid, otherwise return false

        Note: A board does not need to be full or be solvable to be valid.

        Constraints:

        board.length == 9
        board[i].length == 9
        board[i][j] is a digit 1-9 or '.'.
    */

    public boolean isValidSudoku(char[][] board) {
        Set<Integer> memo = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            memo.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (memo.contains(+board[i][j])) {
                        return false;
                    }
                    memo.add(+board[i][j]);
                }
            }

            memo.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (memo.contains(+board[j][i])) {
                        return false;
                    }
                    memo.add(+board[j][i]);
                }
            }
        }

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                memo.clear();

                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] != '.') {
                            if (memo.contains(+board[k][l])) {
                                return false;
                            }
                            memo.add(+board[k][l]);
                        }
                    }
                }

            }
        }

        return true;
    }
}
