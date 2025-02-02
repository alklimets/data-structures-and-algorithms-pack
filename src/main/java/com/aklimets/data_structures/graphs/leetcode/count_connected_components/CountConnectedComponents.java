package com.aklimets.data_structures.graphs.leetcode.count_connected_components;

import java.util.*;

public class CountConnectedComponents {

    /*
        You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
        Return the number of connected components in the graph.

        Example 1:
        Input: n = 5, edges = [[0,1],[1,2],[3,4]]
        Output: 2

        Example 2:
        Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
        Output: 1

        Constraints:

        1 <= n <= 2000
        1 <= edges.length <= 5000
        edges[i].length == 2
        0 <= ai <= bi < n
        ai != bi
        There are no repeated edges.
    */

    public int countComponents(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) continue;
            dfs(i, -1, graph, visited);
            res++;
        }

        return res;
    }

    private void dfs(int start, int parent, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(start)) return;
        visited.add(start);
        for (int rel : graph.getOrDefault(start, List.of())) {
            if (rel != parent) {
                dfs(rel, start, graph, visited);
            }
        }
    }
}
