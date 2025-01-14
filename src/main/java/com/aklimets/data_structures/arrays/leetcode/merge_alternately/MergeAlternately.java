package com.aklimets.data_structures.arrays.leetcode.merge_alternately;

public class MergeAlternately {

    /*
        You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
        Return the merged string.
        Example 1:

        Input: word1 = "abc", word2 = "pqr"
        Output: "apbqcr"
        Explanation: The merged string will be merged as so:
        word1:  a   b   c
        word2:    p   q   r
        merged: a p b q c r
        Example 2:

        Input: word1 = "ab", word2 = "pqrs"
        Output: "apbqrs"
        Explanation: Notice that as word2 is longer, "rs" is appended to the end.
        word1:  a   b
        word2:    p   q   r   s
        merged: a p b q   r   s
        Example 3:

        Input: word1 = "abcd", word2 = "pq"
        Output: "apbqcd"
        Explanation: Notice that as word1 is longer, "cd" is appended to the end.
        word1:  a   b   c   d
        word2:    p   q
        merged: a p b q c   d
    */

    public String mergeAlternately(String word1, String word2) {
        char[] arr = new char[word1.length() + word2.length()];

        int index = 0;
        int count = 0;
        int limit = Math.min(word1.length(), word2.length());
        for (int i = 0; i < limit; i++) {
            count++;
            arr[index++] = word1.charAt(i);
            arr[index++] = word2.charAt(i);
        }
        if (word1.length() > limit) {
            for (int i = limit; i < word1.length(); i++) {
                arr[index++] = word1.charAt(i);
            }
        } else if (word2.length() > limit) {
            for (int i = limit; i < word2.length(); i++) {
                arr[index++] = word2.charAt(i);
            }
        }
        return new String(arr);
    }
}
