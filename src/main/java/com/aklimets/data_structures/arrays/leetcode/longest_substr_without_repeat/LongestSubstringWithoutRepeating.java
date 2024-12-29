package com.aklimets.data_structures.arrays.leetcode.longest_substr_without_repeat;

import java.util.*;

public class LongestSubstringWithoutRepeating {

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
