package com.aklimets.data_structures.graphs.leetcode.course_schedule;

import java.util.*;

public class CourseSchedule {

    /*
        You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take course b first if you want to take course a.
        The pair [0, 1], indicates that must take course 1 before taking course 0.
        There are a total of numCourses courses you are required to take, labeled from 0 to numCourses - 1.
        Return true if it is possible to finish all courses, otherwise return false.

        Example 1:
        Input: numCourses = 2, prerequisites = [[0,1]]
        Output: true
        Explanation: First take course 1 (no prerequisites) and then take course 0.

        Example 2:
        Input: numCourses = 2, prerequisites = [[0,1],[1,0]]
        Output: false
        Explanation: In order to take course 1 you must take course 0, and to take course 0 you must take course 1. So it is impossible.

        Constraints:

        1 <= numCourses <= 1000
        0 <= prerequisites.length <= 1000
        All prerequisite pairs are unique.
    */

    public boolean canFinish(int numCourses, int[][] relations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] rel : relations) {
            graph.computeIfAbsent(rel[0], v -> new ArrayList<>()).add(rel[1]);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Integer course, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(course)) return false;

        visited.add(course);
        for (Integer related : graph.getOrDefault(course, List.of())) {
            if (!dfs(related, graph, visited)) {
                return false;
            }
        }
        visited.remove(course);
        return true;
    }

    public boolean canFinish2(int numCourses, int[][] relations) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] rel : relations) {
            graph.computeIfAbsent(rel[0], v -> new ArrayList<>()).add(rel[1]);
            inDegree[rel[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int finish = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            finish++;

            for (Integer related : graph.getOrDefault(poll, List.of())) {
                inDegree[related]--;
                if (inDegree[related] == 0) {
                    queue.offer(related);
                }
            }
        }
        return finish == numCourses;
    }
}
