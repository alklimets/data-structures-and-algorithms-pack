package com.aklimets.data_structures.heaps.freq_sort;

import java.util.PriorityQueue;
import java.util.Queue;

public class FreqSort {

    /*
        Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
        Return the sorted string. If there are multiple answers, return any of them.

        Example 1:
        Input: s = "tree"
        Output: "eert"
        Explanation: 'e' appears twice while 'r' and 't' both appear once.
        So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

        Example 2:
        Input: s = "cccaaa"
        Output: "aaaccc"
        Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
        Note that "cacaca" is incorrect, as the same characters must be together.

        Example 3:
        Input: s = "Aabb"
        Output: "bbAa"
        Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
        Note that 'A' and 'a' are treated as two different characters.

        Constraints:

        1 <= s.length <= 5 * 10^5
        s consists of uppercase and lowercase English letters and digits.
    */

    public String frequencySort(String s) {
        int size = (int) 'z' + 1;
        int[] freq = new int[size];

        for (char ch : s.toCharArray()) {
            freq[(int) ch]++;
        }

        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < size; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[] {freq[i], i});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] record = maxHeap.poll();
            sb.append(String.valueOf((char) record[1]).repeat(Math.max(0, record[0])));
        }
        return sb.toString();
    }
}
