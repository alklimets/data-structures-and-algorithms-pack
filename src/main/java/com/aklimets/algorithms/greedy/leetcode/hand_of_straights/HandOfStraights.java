package com.aklimets.algorithms.greedy.leetcode.hand_of_straights;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class HandOfStraights {

    /*
        Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize,
        and consists of groupSize consecutive cards.
        Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true
        if she can rearrange the cards, or false otherwise.

        Example 1:
        Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
        Output: true
        Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

        Example 2:
        Input: hand = [1,2,3,4,5], groupSize = 4
        Output: false
        Explanation: Alice's hand can not be rearranged into groups of 4.

        Constraints:

        1 <= hand.length <= 10^4
        0 <= hand[i] <= 10^9
        1 <= groupSize <= hand.length

    */

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize > 0) return false;

        Map<Integer, Integer> counts = new HashMap<>();
        Queue<Integer> heap = new PriorityQueue<>();
        for (int card : hand) {
            heap.offer(card);
            counts.compute(card, (k, v) -> v == null ? 1 : v + 1);
        }

        while (!heap.isEmpty()) {
            while (!heap.isEmpty() && counts.getOrDefault(heap.peek(), 0) == 0) {
                heap.poll();
            }
            if (heap.isEmpty()) return true;

            int min = heap.poll();
            for (int i = min; i < min + groupSize; i++) {
                if (counts.getOrDefault(i, 0) == 0) return false;
                counts.compute(i, (k, v) -> v - 1);
            }
        }

        return true;
    }
}
