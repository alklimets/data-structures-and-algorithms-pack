package com.aklimets.data_structures.graphs.leetcode.redundant_connection;

import java.util.*;

public class RedundantConnection {

    /*
        You are given a connected undirected graph with n nodes labeled from 1 to n. Initially, it contained no cycles and consisted of n-1 edges.
        We have now added one additional edge to the graph. The edge has two different vertices chosen from 1 to n, and was not an edge that previously existed in the graph.
        The graph is represented as an array edges of length n where edges[i] = [ai, bi] represents an edge between nodes ai and bi in the graph.
        Return an edge that can be removed so that the graph is still a connected non-cyclical graph. If there are multiple answers, return the edge that appears last in the input edges.

        Example 1:
        Input: edges = [[1,2],[1,3],[3,4],[2,4]]
        Output: [2,4]

        Example 2:
        Input: edges = [[1,2],[1,3],[1,4],[3,4],[4,5]]
        Output: [3,4]

        Constraints:

        n == edges.length
        3 <= n <= 100
        1 <= edges[i][0] < edges[i][1] <= edges.length
        There are no repeated edges and no self-loops in the input.
    */

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
            nodes.add(edge[0]);
            nodes.add(edge[1]);
        }
        int[] res = new int[]{};
        for (int[] edge : edges) {
            if (canBeRemoved(edge, graph, nodes.size())) res = edge;
        }
        return res;
    }

    private boolean canBeRemoved(int[] edge, Map<Integer, List<Integer>> graph, int size) {
        graph.get(edge[0]).remove((Integer) edge[1]);
        graph.get(edge[1]).remove((Integer) edge[0]);
        Set<Integer> visited = new HashSet<>();
        dfs(edge[0], -1, graph, visited);
        graph.get(edge[0]).add(edge[1]);
        graph.get(edge[1]).add(edge[0]);
        return visited.size() == size;
    }

    private void dfs(int start, int parent, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(start)) {
            visited.clear();
            return;
        }

        visited.add(start);
        for (int rel : graph.getOrDefault(start, List.of())) {
            if (rel == parent) continue;
            dfs(rel, start, graph, visited);
        }
    }
}
