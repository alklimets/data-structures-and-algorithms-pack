package com.aklimets.algorithms.greedy.neetcode.hand_of_straights;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandOfStraits {

    /*
        Hand of Straights
        You are given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize.

        You want to rearrange the cards into groups so that each group is of size groupSize, and card values are consecutively increasing by 1.

        Return true if it's possible to rearrange the cards in this way, otherwise, return false.

        Example 1:

        Input: hand = [1,2,4,2,3,5,3,4], groupSize = 4

        Output: true
        Explanation: The cards can be rearranged as [1,2,3,4] and [2,3,4,5].

        Example 2:

        Input: hand = [1,2,3,3,4,5,6,7], groupSize = 4

        Output: false
        Explanation: The closest we can get is [1,2,3,4] and [3,5,6,7], but the cards in the second group are not consecutive.

        Constraints:

        1 <= hand.length <= 1000
        0 <= hand[i] <= 1000
        1 <= groupSize <= hand.length

    */

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();

        for (int item : hand) {
            map.compute(item, (k, v) -> v == null ? 1 : v + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        map.keySet().forEach(priorityQueue::offer);

        while (!priorityQueue.isEmpty()) {
            int min = priorityQueue.peek();
            for (int i = 0; i < groupSize; i++) {
                if (map.getOrDefault(min, 0) == 0) {
                    return false;
                }
                map.compute(min, (k,v) -> v - 1);
                if (map.get(min++) == 0) priorityQueue.poll();
            }
        }


        return true;
    }

    public static void main(String[] args) {
        System.out.println(new HandOfStraits().isNStraightHand(new int[] {1,2,3,3,4,5,6,7}, 4));
    }
}
