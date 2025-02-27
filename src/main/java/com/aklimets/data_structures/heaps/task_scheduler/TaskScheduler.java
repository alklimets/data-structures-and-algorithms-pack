package com.aklimets.data_structures.heaps.task_scheduler;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

    /*
        You are given an array of CPU tasks tasks, where tasks[i] is an uppercase english character from A to Z. You are also given an integer n.
        Each CPU cycle allows the completion of a single task, and tasks may be completed in any order.
        The only constraint is that identical tasks must be separated by at least n CPU cycles, to cooldown the CPU.
        Return the minimum number of CPU cycles required to complete all tasks.

        Example 1:
        Input: tasks = ["X","X","Y","Y"], n = 2
        Output: 5
        Explanation: A possible sequence is: X -> Y -> idle -> X -> Y.

        Example 2:
        Input: tasks = ["A","A","A","B","C"], n = 3
        Output: 9
        Explanation: A possible sequence is: A -> B -> C -> Idle -> A -> Idle -> Idle -> Idle -> A.

        Constraints:

        1 <= tasks.length <= 1000
        0 <= n <= 100
    */

    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        Queue<int[]> cooldown = new LinkedList<>();

        for (int fr : freq) {
            if (fr > 0) {
                maxHeap.offer(fr);
            }
        }
        int time = 0;
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int max = maxHeap.poll();
                if (max > 1) {
                    cooldown.offer(new int[] {max - 1, time + n});
                }
            }
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                maxHeap.offer(cooldown.poll()[0]);
            }
        }

        return time;

    }

    public static void main(String[] args) {
        System.out.println(new TaskScheduler().leastInterval(new char[] {'A', 'A', 'A', 'B', 'C'}, 3));
    }
}
