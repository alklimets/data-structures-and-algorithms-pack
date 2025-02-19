package com.aklimets.challenges.neetcode.backtracking.palindrome_partitioning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {

    /*
        Given a string s, partition s such that every substring of the partition is a
        palindrome. Return all possible palindrome partitioning of s.

        Example 1:
        Input: s = "aab"
        Output: [["a","a","b"],["aa","b"]]

        Example 2:
        Input: s = "a"
        Output: [["a"]]

        Constraints:

        1 <= s.length <= 16
        s contains only lowercase English letters.
    */

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, new LinkedList<>());
        return res;
    }

    private void dfs(String source, int start, LinkedList<String> cur) {
        if (start == source.length()) res.add(new ArrayList<>(cur));

        for (int i = start; i < source.length(); i++) {
            if (isPalindrome(source, start, i)) {
                cur.add(source.substring(start, i + 1));
                dfs(source, i + 1, cur);
                cur.removeLast();
            }
        }
    }


    private boolean isPalindrome(String source, int l, int r) {
        while (l < r) {
            if (source.charAt(l) != source.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
    }
}
