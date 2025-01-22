package com.aklimets.data_structures.tries.min_extra_char;

import java.util.*;

public class MinExtraChar {

    /*
        You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.
        Return the minimum number of extra characters left over if you break up s optimally.

        Example 1:

        Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
        Output: 1
        Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.

        Example 2:

        Input: s = "sayhelloworld", dictionary = ["hello","world"]
        Output: 3
        Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.

        Constraints:

        1 <= s.length <= 50
        1 <= dictionary.length <= 50
        1 <= dictionary[i].length <= 50
        dictionary[i] and s consists of only lowercase English letters
        dictionary contains distinct words
    */


    // DP solution
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        return dfs(s, dict, 0, dict.stream().map(String::length).max((a, b) -> a - b).get());
    }

    Map<Integer, Integer> dp = new HashMap<>();

    private int dfs(String s, Set<String> dictionary, int i, int maxLength) {
        if (i == s.length()) return 0;
        if (dp.containsKey(i)) return dp.get(i);
        int end = Math.min(s.length(), i + maxLength);
        int res = 1 + dfs(s, dictionary, i + 1, maxLength);
        for (int j = i; j <= end; j++) {
            if (dictionary.contains(s.substring(i, j))) {
                res = Math.min(res, dfs(s, dictionary, j, maxLength));
            }
        }
        dp.put(i, res);
        return res;
    }









    // faster
    public int minExtraChar2(String s, String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String ss : dictionary) {
            insert(ss, root);
        }
        return dfsWithTrie(s, root, 0);
    }

    private int dfsWithTrie(String s, TrieNode trie, int i) {
        if (i == s.length()) return 0;
        if (dp.containsKey(i)) return dp.get(i);
        int res = 1 + dfsWithTrie(s, trie, i + 1);
        for (int j = i; j < s.length(); j++) {
            if (trie.nodes[s.charAt(j) - 'a'] == null) break;
            trie = trie.nodes[s.charAt(j) - 'a'];
            if (trie.isWord) {
                res = Math.min(res, dfsWithTrie(s, trie, j + 1));
            }
        }
        dp.put(i, res);
        return res;
    }

    static class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isWord = false;
    }

    public void insert(String word, TrieNode root) {
        char[] chars = word.toCharArray();
        TrieNode current = root;
        for (char ch : chars) {
            if (current.nodes[ch - 'a'] == null) {
                TrieNode node = new TrieNode();
                current.nodes[ch - 'a'] = node;
            }
            current = current.nodes[ch - 'a'];
        }
        current.isWord = true;
    }
}
