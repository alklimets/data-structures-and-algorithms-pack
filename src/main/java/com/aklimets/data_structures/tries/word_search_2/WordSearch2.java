package com.aklimets.data_structures.tries.word_search_2;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

    /*
        Given a 2-D grid of characters board and a list of strings words, return all words that are present in the grid.
        For a word to be present it must be possible to form the word with a path in the board with horizontally or vertically neighboring cells. The same cell may not be used more than once in a word.

        Example 1:
        Input:
        board = [
          ["a","b","c","d"],
          ["s","a","a","t"],
          ["a","c","k","e"],
          ["a","c","d","n"]
        ],
        words = ["bat","cat","back","backend","stack"]

        Output: ["cat","back","backend"]
        Example 2:
        Input:
        board = [
          ["x","o"],
          ["x","o"]
        ],
        words = ["xoxo"]

        Output: []
        Constraints:

        1 <= board.length, board[i].length <= 10
        board[i] consists only of lowercase English letter.
        1 <= words.length <= 100
        1 <= words[i].length <= 10
        words[i] consists only of lowercase English letters.
        All strings within words are distinct.
    */

    static class TreeNode {
        TreeNode[] nodes = new TreeNode[26];
        String word;

        void insert(String word) {
            TreeNode current = this;
            for (char ch : word.toCharArray()) {
                if (current.nodes[ch - 'a'] == null) {
                    current.nodes[ch - 'a'] = new TreeNode();
                }
                current = current.nodes[ch - 'a'];
            }
            current.word = word;
        }
    }

    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TreeNode trie = new TreeNode();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j);
            }
        }
        return res;
    }

    private void dfs(char[][] board, TreeNode trie, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] == '*' || trie.nodes[board[i][j] - 'a'] == null) {
            return;
        }

        char buff = board[i][j];
        board[i][j] = '*';

        trie = trie.nodes[buff - 'a'];
        if (trie.word != null) {
            res.add(trie.word);
            trie.word = null;
        }

        dfs(board, trie, i + 1, j);
        dfs(board, trie, i, j + 1);
        dfs(board, trie, i - 1, j);
        dfs(board, trie, i, j - 1);

        board[i][j] = buff;

    }
}
