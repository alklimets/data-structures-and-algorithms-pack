package com.aklimets.data_structures.graphs.leetcode.valid_tree;

import java.util.*;

public class ValidTree {

    /*
        Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
        Example 1:

        Input:
        n = 5
        edges = [[0, 1], [0, 2], [0, 3], [1, 4]]

        Output:
        true
        Example 2:

        Input:
        n = 5
        edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]

        Output:
        false
        Note:

        You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
        Constraints:

        1 <= n <= 100
        0 <= edges.length <= n * (n - 1) / 2
    */

    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }

        if (!dfs(0, -1, visited, graph)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs(int edge, int parent, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        if (visited.contains(edge)) return false;

        visited.add(edge);
        for (Integer relative : graph.getOrDefault(edge, List.of())) {
            if (relative == parent) continue;
            if (!dfs(relative, edge, visited, graph)) {
                return false;
            }
        }
        return true;
    }
}
