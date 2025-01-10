package com.aklimets.challenges.neetcode.sliding_window.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    /*
        Minimum Window Substring
        Given two strings s and t, return the shortest substring of s such that every character in t, including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".

        You may assume that the correct output is always unique.

        Example 1:

        Input: s = "OUZODYXAZV", t = "XYZ"

        Output: "YXAZ"
        Explanation: "YXAZ" is the shortest substring that includes "X", "Y", and "Z" from string t.

        Example 2:

        Input: s = "xyz", t = "xyz"

        Output: "xyz"
        Example 3:

        Input: s = "x", t = "xy"

        Output: ""
        Constraints:

        1 <= s.length <= 1000
        1 <= t.length <= 1000
        s and t consist of uppercase and lowercase English letters.
    */

    public String minWindow(String source, String given) {
        if (source.length() < given.length()) return "";
        String minSubstring = "";
        Map<Character, Integer> required = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char ch : given.toCharArray()) {
            required.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }

        int l = 0;
        while (l < source.length() && !given.contains(String.valueOf(source.charAt(l)))) {
            l++;
        }
        int r = l;
        while (r < source.length()) {
            window.compute(source.charAt(r), (k, v) -> v == null ? 1 : v + 1);
            if (required.entrySet().stream().allMatch(entry -> window.getOrDefault(entry.getKey(), -1) >= entry.getValue())) {
                char currentLeft = source.charAt(l);
                while (l <= r && (source.charAt(l) == currentLeft || !given.contains(String.valueOf(source.charAt(l))))) {
                    if (required.get(currentLeft) <= window.get(currentLeft)) {
                        String substring = source.substring(l, r + 1);
                        if (minSubstring.length() == 0 || substring.length() < minSubstring.length()) minSubstring = substring;
                    }
                    window.compute(source.charAt(l++), (k, v) -> v - 1);
                }
            }
            r++;
        }
        return minSubstring;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("OUZODYXAZV", "XYZ"));
        System.out.println(new MinimumWindowSubstring().minWindow("a", "a"));
        System.out.println(new MinimumWindowSubstring().minWindow("a", "b"));
    }
}
