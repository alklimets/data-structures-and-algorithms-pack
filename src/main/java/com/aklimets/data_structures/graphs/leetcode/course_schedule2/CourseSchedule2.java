package com.aklimets.data_structures.graphs.leetcode.course_schedule2;

import java.util.*;

public class CourseSchedule2 {

    /*
        You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take course b first if you want to take course a.
        For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
        There are a total of numCourses courses you are required to take, labeled from 0 to numCourses - 1.
        Return a valid ordering of courses you can take to finish all courses. If there are many valid answers, return any of them. If it's not possible to finish all courses, return an empty array.

        Example 1:
        Input: numCourses = 3, prerequisites = [[1,0]]
        Output: [0,1,2]
        Explanation: We must ensure that course 0 is taken before course 1.

        Example 2:
        Input: numCourses = 3, prerequisites = [[0,1],[1,2],[2,0]]
        Output: []
        Explanation: It's impossible to finish all courses.

        Constraints:

        1 <= numCourses <= 1000
        0 <= prerequisites.length <= 1000
        All prerequisite pairs are unique.
    */

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] req : prerequisites) {
            graph.computeIfAbsent(req[1], (v) -> new ArrayList<>()).add(req[0]);
            inDegree[req[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            res.add(node);
            for (int rel : graph.getOrDefault(node, List.of())) {
                inDegree[rel]--;
                if (inDegree[rel] == 0) {
                    queue.offer(rel);
                }
            }
        }

        if (res.size() != numCourses) {
            return new int[]{};
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
