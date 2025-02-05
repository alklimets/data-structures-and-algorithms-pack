package com.aklimets.data_structures.graphs.leetcode.word_ladder;

import java.util.*;

public class WordLadder {

    /*
        A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
        Every adjacent pair of words differs by a single letter.
        Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
        sk == endWord
        Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

        Example 1:
        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
        Output: 5
        Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

        Example 2:
        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
        Output: 0
        Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

        Constraints:

        1 <= beginWord.length <= 10
        endWord.length == beginWord.length
        1 <= wordList.length <= 5000
        wordList[i].length == beginWord.length
        beginWord, endWord, and wordList[i] consist of lowercase English letters.
        beginWord != endWord
        All the words in wordList are unique.
    */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> patterns = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();
                arr[i] = '*';
                String pattern = new String(arr);
                patterns.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }


        int res = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        visited.add(beginWord);
        queue.offer(beginWord);

        while(!queue.isEmpty()) {
            res++;
            for (int ii = queue.size(); ii > 0; ii--) {
                String word = queue.poll();
                if (word.equals(endWord)) return res;

                for (int i = 0; i < word.length(); i++) {
                    char[] arr = word.toCharArray();
                    arr[i] = '*';
                    String pattern = new String(arr);
                    for (String relative : patterns.getOrDefault(pattern, List.of())) {
                        if (!visited.contains(relative)) {
                            visited.add(relative);
                            queue.offer(relative);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
