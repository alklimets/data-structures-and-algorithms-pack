package com.aklimets.data_structures.arrays.leetcode.longest_substr_without_repeat;

import java.util.*;

public class LongestSubstringWithoutRepeating {

    /*
        Longest Substring Without Repeating Characters
        Given a string s, find the length of the longest substring without duplicate characters.

        A substring is a contiguous sequence of characters within a string.

        Example 1:

        Input: s = "zxyzxyz"

        Output: 3
        Explanation: The string "xyz" is the longest without duplicate characters.

        Example 2:

        Input: s = "xxxx"

        Output: 1
        Constraints:

        0 <= s.length <= 1000
        s may consist of printable ASCII characters.

    */

    Queue<String> sequence = new LinkedList<>();
    Set<String> included = new HashSet<>();

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            String val = String.valueOf(ch);
            if (!included.contains(val)) {
                sequence.add(val);
                included.add(val);
                max = Math.max(max, included.size());
            } else {
                while (included.contains(val)) {
                    String poll = sequence.poll();
                    included.remove(poll);
                }
                sequence.add(val);
                included.add(val);
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int max = 0, l = 0, r = 0;
        char[] charArray = s.toCharArray();
        while (r < charArray.length) {
            String val = String.valueOf(charArray[r]);
            if (!included.contains(val)) {
                included.add(val);
                max = Math.max(max, included.size());
            } else {
                while (included.contains(val)) {
                    String poll = String.valueOf(charArray[l++]);
                    included.remove(poll);
                }
                included.add(val);
            }
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeating().lengthOfLongestSubstring2("tmmzuxt"));
    }
}
