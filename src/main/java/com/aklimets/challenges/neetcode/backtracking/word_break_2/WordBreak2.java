package com.aklimets.challenges.neetcode.backtracking.word_break_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordBreak2 {

    /*
        Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
        Note that the same word in the dictionary may be reused multiple times in the segmentation.
        Example 1:
        Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
        Output: ["cats and dog","cat sand dog"]

        Example 2:
        Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
        Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
        Explanation: Note that you are allowed to reuse a dictionary word.

        Example 3:
        Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
        Output: []

        Constraints:

        1 <= s.length <= 20
        1 <= wordDict.length <= 1000
        1 <= wordDict[i].length <= 10
        s and wordDict[i] consist of only lowercase English letters.
        All the strings of wordDict are unique.
        Input is generated in a way that the length of the answer doesn't exceed 10^5.
    */

    static class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isWord = false;

        void insert(String word) {
            TrieNode copy = this;
            for (char ch : word.toCharArray()) {
                if (copy.nodes[ch - 'a'] == null) {
                    copy.nodes[ch - 'a'] = new TrieNode();
                }
                copy = copy.nodes[ch - 'a'];
            }
            copy.isWord = true;
        }
    }

    TrieNode trie = new TrieNode();

    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            trie.insert(word);
        }
        dfs(s, 0, new LinkedList<>());
        return res;
    }

    private void dfs(String given, int start, LinkedList<String> cur) {
        if (start == given.length()) {
            res.add(String.join(" ", cur));
            return;
        }
        TrieNode trieCopy = trie;
        int limit = Math.min(start + 10, given.length());
        for (int i = start; i < limit; i++) {
            if (trieCopy.nodes[given.charAt(i) - 'a'] == null) break;
            trieCopy = trieCopy.nodes[given.charAt(i) - 'a'];
            if (trieCopy.isWord) {
                String substr = given.substring(start, i + 1);
                cur.add(substr);
                dfs(given, i + 1, cur);
                cur.removeLast();
            }
        }
    }
}
