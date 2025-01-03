package com.aklimets.algorithms.dynamic_programming.neetcode.word_break;

import java.util.*;

public class WordBreak {

    /*
        Word Break
        Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of dictionary words.

        You are allowed to reuse words in the dictionary an unlimited number of times. You may assume all dictionary words are unique.

        Example 1:

        Input: s = "neetcode", wordDict = ["neet","code"]

        Output: true
        Explanation: Return true because "neetcode" can be split into "neet" and "code".

        Example 2:

        Input: s = "applepenapple", wordDict = ["apple","pen","ape"]

        Output: true
        Explanation: Return true because "applepenapple" can be split into "apple", "pen" and "apple". Notice that we can reuse words and also not use all the words.

        Example 3:

        Input: s = "catsincars", wordDict = ["cats","cat","sin","in","car"]

        Output: false
        Constraints:

        1 <= s.length <= 200
        1 <= wordDict.length <= 100
        1 <= wordDict[i].length <= 20
        s and wordDict[i] consist of only lowercase English letters.
    */

    private Map<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict));
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.length() == 0) return true;
        if (memo.containsKey(s)) return memo.get(s);
        int limit = Math.min(s.length() + 1, 21);
        boolean res = false;
        for (int i = 1; i < limit; i++) {
            String substring = s.substring(0, i);
            if (wordDict.contains(substring)) {
                res = res || wordBreak(s.substring(i), wordDict);
            }
        }
        memo.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("code", List.of("neet", "code")));
    }

}
