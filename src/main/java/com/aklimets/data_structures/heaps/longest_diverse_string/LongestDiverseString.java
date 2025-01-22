package com.aklimets.data_structures.heaps.longest_diverse_string;

import java.util.PriorityQueue;
import java.util.Queue;

public class LongestDiverseString {

    /*
        A string s is called happy if it satisfies the following conditions:

        s only contains the letters 'a', 'b', and 'c'.
        s does not contain any of "aaa", "bbb", or "ccc" as a substring.
        s contains at most a occurrences of the letter 'a'.
        s contains at most b occurrences of the letter 'b'.
        s contains at most c occurrences of the letter 'c'.
        Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".

        A substring is a contiguous sequence of characters within a string.
        Example 1:
        Input: a = 1, b = 1, c = 7
        Output: "ccaccbcc"
        Explanation: "ccbccacc" would also be a correct answer.

        Example 2:
        Input: a = 7, b = 1, c = 0
        Output: "aabaa"
        Explanation: It is the only correct answer in this case.
    */

    public String longestDiverseString(int a, int b, int c) {
        Queue<int[]> maxHeap = new PriorityQueue<>((aa, bb) -> bb[1] - aa[1]);
        if (a > 0) maxHeap.offer(new int[] {'a', a});
        if (b > 0) maxHeap.offer(new int[] {'b', b});
        if (c > 0) maxHeap.offer(new int[] {'c', c});

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int[] max = maxHeap.poll();
            char ch = (char) max[0];

            if (sb.length() > 1 && (sb.charAt(sb.length() - 1) == ch && sb.charAt(sb.length() - 2) == ch)) {
                if (maxHeap.isEmpty()) break;

                int[] next = maxHeap.poll();
                sb.append((char) next[0]);
                next[1]--;
                if (next[1] > 0) maxHeap.offer(next);
                maxHeap.offer(max);
            } else {
                sb.append((char) max[0]);
                max[1]--;
                if (max[1] > 0) maxHeap.offer(max);
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongestDiverseString().longestDiverseString(7,0,0));
    }
}
