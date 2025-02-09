package com.aklimets.data_structures.arrays.neetcode.valid_anagram;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValidAnagram {

    /*
        Valid Anagram
        Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

        An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

        Example 1:

        Input: s = "racecar", t = "carrace"

        Output: true
        Example 2:

        Input: s = "jar", t = "jam"

        Output: false
        Constraints:

        s and t consist of lowercase English letters.
    */

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Integer, Long> sCount = s.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> tCount = t.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return sCount.equals(tCount);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int i : arr) {
            if (i != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram2("racecar", "carrace"));
    }
}
