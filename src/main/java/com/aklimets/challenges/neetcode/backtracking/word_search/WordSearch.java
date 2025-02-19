package com.aklimets.challenges.neetcode.backtracking.word_search;

public class WordSearch {

    /*
        Given a 2-D grid of characters board and a string word, return true if the word is present in the grid, otherwise return false.
        For the word to be present it must be possible to form it with a path in the board with horizontally or vertically neighboring cells. The same cell may not be used more than once in a word.

        Example 1:
        Input:
        board = [
          ["A","B","C","D"],
          ["S","A","A","T"],
          ["A","C","A","E"]
        ],
        word = "CAT"
        Output: true

        Example 2:
        Input:
        board = [
          ["A","B","C","D"],
          ["S","A","A","T"],
          ["A","C","A","E"]
        ],
        word = "BAT"
        Output: false

        Constraints:

        1 <= board.length, board[i].length <= 5
        1 <= word.length <= 10
        board and word consists of only lowercase and uppercase English letters.

    */

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int letter) {
        if (letter == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '*' || word.charAt(letter) != board[i][j]) {
            return false;
        }

        board[i][j] = '*';
        boolean result = false;

        result |= dfs(board, word, i + 1, j, letter + 1);
        result |= dfs(board, word, i, j + 1, letter + 1);
        result |= dfs(board, word, i - 1, j, letter + 1);
        result |= dfs(board, word, i, j - 1, letter + 1);

        board[i][j] = word.charAt(letter);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{
                {'A', 'B', 'C', 'D'},
                {'S', 'A', 'A', 'T'},
                {'A', 'C', 'A', 'E'}
        }, "ABCDTAASACAE"));
    }
}
