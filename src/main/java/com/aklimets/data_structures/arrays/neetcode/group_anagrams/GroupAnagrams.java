package com.aklimets.data_structures.arrays.neetcode.group_anagrams;

import java.util.*;

public class GroupAnagrams {
    /*
        Group Anagrams

        Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

        An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

        Example 1:

        Input: strs = ["act","pots","tops","cat","stop","hat"]

        Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
        Example 2:

        Input: strs = ["x"]

        Output: [["x"]]
        Example 3:

        Input: strs = [""]

        Output: [[""]]
        Constraints:

        1 <= strs.length <= 1000.
        0 <= strs[i].length <= 100
        strs[i] is made up of lowercase English letters.
    */

    /*
        Complexity O(m*n)
    */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<String, Integer>, List<String>> result = new HashMap<>();
        for (String str : strs) {
            Map<String, Integer> represent = new HashMap<>();
            for (char c : str.toCharArray()) {
                represent.compute(String.valueOf(c), (k, v) -> v == null ? 1 : v + 1);
            }
            result.computeIfAbsent(represent, i -> new ArrayList<>()).add(str);
        }

        return result.values().stream().toList();
    }

    /*
        With sorting, complexity O(M * N*logN)
    */
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            result.computeIfAbsent(s, v -> new ArrayList<>()).add(str);
        }

        return result.values().stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams2(new String[]{"act", "pots", "tops", "cat", "stop", "hat"}));
    }
}
