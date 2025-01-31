package com.aklimets.data_structures.stacks.leetcode.asteriod_collision;

import java.util.Stack;

public class AsteroidCollision {

    /*
        We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.
        For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
        Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

        Example 1:
        Input: asteroids = [5,10,-5]
        Output: [5,10]
        Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

        Example 2:
        Input: asteroids = [8,-8]
        Output: []
        Explanation: The 8 and -8 collide exploding each other.

        Example 3:
        Input: asteroids = [10,2,-5]
        Output: [10]
        Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.


        Constraints:

        2 <= asteroids.length <= 104
        -1000 <= asteroids[i] <= 1000
        asteroids[i] != 0
    */

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(asteroid);
                    continue;
                }
                int meet = stack.pop();
                if (meet > Math.abs(asteroid)) {
                    stack.push(meet);
                } else if (meet < 0) {
                    stack.push(meet);
                    stack.push(asteroid);
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
