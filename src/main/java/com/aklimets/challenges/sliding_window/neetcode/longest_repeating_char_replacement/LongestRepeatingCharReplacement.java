package com.aklimets.challenges.sliding_window.neetcode.longest_repeating_char_replacement;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplacement {

    /*
        Longest Repeating Character Replacement
        You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.

        After performing at most k replacements, return the length of the longest substring which contains only one distinct character.

        Example 1:

        Input: s = "XYYX", k = 2

        Output: 4
        Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.

        Example 2:

        Input: s = "AAABABB", k = 1

        Output: 5
        Constraints:

        1 <= s.length <= 1000
        0 <= k <= s.length
    */


    public int characterReplacement(String s, int k) {
        if (s.length() == 1) return 1;
        int max = 0;
        int l = 0, r = 0;
        Map<String, Integer> counter = new HashMap<>();

        while (r < s.length()) {
            counter.compute(String.valueOf(s.charAt(r)), (key, val) -> val == null ? 1 : val + 1);

            int windowLength = r - l + 1;
            int mostFreq = counter.values().stream().max(Integer::compareTo).get();

            if (windowLength - mostFreq <= k) {
                max = Math.max(max, windowLength);
                r++;
            } else {
                counter.compute(String.valueOf(s.charAt(l++)), (key, val) -> val - 1);
                counter.compute(String.valueOf(s.charAt(r)), (key, val) -> val - 1);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharReplacement().characterReplacement("AABABBA", 1));
    }
}
