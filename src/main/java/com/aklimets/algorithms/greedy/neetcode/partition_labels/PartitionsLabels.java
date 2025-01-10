package com.aklimets.algorithms.greedy.neetcode.partition_labels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionsLabels {

    /*
        Partition Labels
        You are given a string s consisting of lowercase english letters.

        We want to split the string into as many substrings as possible, while ensuring that each letter appears in at most one substring.

        Return a list of integers representing the size of these substrings in the order they appear in the string.

        Example 1:

        Input: s = "xyxxyzbzbbisl"

        Output: [5, 5, 1, 1, 1]
        Explanation: The string can be split into ["xyxxy", "zbzbb", "i", "s", "l"].

        Example 2:

        Input: s = "abcabc"

        Output: [6]
        Constraints:

        1 <= s.length <= 100
    */

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastCharPositions = new HashMap<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            lastCharPositions.put(chars[i], i);
        }

        List<Integer> result = new ArrayList<>();
        int ind = 0;
        while (ind < chars.length) {
            int maxIndex = ind, current = ind;
            while (current <= maxIndex) {
                maxIndex = Math.max(maxIndex, lastCharPositions.get(chars[current++]));
            }
            result.add(maxIndex - ind + 1);
            ind = maxIndex + 1;
        }
        return result;
    }
}
