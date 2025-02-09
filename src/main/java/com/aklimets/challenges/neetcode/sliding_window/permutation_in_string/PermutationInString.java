package com.aklimets.challenges.neetcode.sliding_window.permutation_in_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    /*
        Permutation in String
        You are given two strings s1 and s2.

        Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.

        Both strings only contain lowercase letters.

        Example 1:

        Input: s1 = "abc", s2 = "lecabee"

        Output: true
        Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".

        Example 2:

        Input: s1 = "abc", s2 = "lecaabee"

        Output: false
        Constraints:

        1 <= s1.length, s2.length <= 1000
    */

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int l = 0, r = s1.length() - 1;

        Map<Character, Integer> targetPerm = new HashMap<>();
        Map<Character, Integer> currentPerm = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            targetPerm.compute(s1.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            currentPerm.compute(s2.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        if (targetPerm.equals(currentPerm)) return true;
        while (r < s2.length() - 1) {
            currentPerm.compute(s2.charAt(l++), (k, v) -> v - 1);
            if (currentPerm.get(s2.charAt(l - 1)) == 0) currentPerm.remove(s2.charAt(l - 1));
            currentPerm.compute(s2.charAt(++r), (k, v) -> v == null ? 1 : v + 1);
            if (targetPerm.equals(currentPerm)) return true;
        }

        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int l = 0, r = s1.length() - 1;

        int[] targetFreq = new int[26];
        int[] currentFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            targetFreq[s1.charAt(i) - 'a']++;
            currentFreq[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(targetFreq, currentFreq)) return true;
        while (r < s2.length() - 1) {
            currentFreq[s2.charAt(l++) - 'a']--;
            currentFreq[s2.charAt(++r) - 'a']++;
            if (Arrays.equals(targetFreq, currentFreq)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("adc", "dcda"));
    }

}
