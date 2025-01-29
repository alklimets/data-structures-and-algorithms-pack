package com.aklimets.challenges.leetcode.fruit_into_basket;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitIntoBasket {

    /*
        You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
        You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
        You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
        Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
        Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
        Given the integer array fruits, return the maximum number of fruits you can pick.

        Example 1:
        Input: fruits = [1,2,1]
        Output: 3
        Explanation: We can pick from all 3 trees.

        Example 2:
        Input: fruits = [0,1,2,2]
        Output: 3
        Explanation: We can pick from trees [1,2,2].
        If we had started at the first tree, we would only pick from trees [0,1].

        Example 3:
        Input: fruits = [1,2,3,2,2]
        Output: 4
        Explanation: We can pick from trees [2,3,2,2].
        If we had started at the first tree, we would only pick from trees [1,2].


        Constraints:

        1 <= fruits.length <= 10^5
        0 <= fruits[i] < fruits.length
    */

    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, max = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        while (r < fruits.length) {
            counts.compute(fruits[r], (k, v) -> v == null ? 1 : v + 1);
            if (counts.size() <= 2) {
                max = Math.max(max, r - l + 1);
            } else {
                while (counts.size() > 2) {
                    int fruit = fruits[l];
                    counts.compute(fruit, (k, v) -> v - 1);
                    if (counts.get(fruit) == 0) counts.remove(fruit);
                    l++;
                }
            }
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new FruitIntoBasket().totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
    }
}
