package com.aklimets.data_structures.heaps.reorganize_string;

import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {

    /*
        Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
        Return any possible rearrangement of s or return "" if not possible.

        Example 1:
        Input: s = "aab"
        Output: "aba"

        Example 2:
        Input: s = "aaab"
        Output: ""

        Constraints:

        1 <= s.length <= 500
        s consists of lowercase English letters.
    */

    public String reorganizeString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int[] freqs = new int[26];
        for (char ch : chars) {
            freqs[ch - 'a']++;
        }

        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] > 0) {
                maxHeap.offer(new int[]{freqs[i], i});
            }
        }
        int[] hold = null;
        while (!maxHeap.isEmpty()) {
            int[] poll = maxHeap.poll();
            char ch = (char) (poll[1] + 'a');
            if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == ch) {
                return "";
            }
            sb.append(ch);

            if (hold != null) {
                maxHeap.offer(hold);
            }
            poll[0]--;
            if (poll[0] > 0) {
                hold = poll;
            } else {
                hold = null;
            }
        }


        return hold == null ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(new ReorganizeString().reorganizeString("aaab"));
    }
}
