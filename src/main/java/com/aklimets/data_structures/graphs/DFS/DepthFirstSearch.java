package com.aklimets.data_structures.graphs.DFS;

import java.util.*;

public class DepthFirstSearch {

    public boolean hasCycle(Map<String, List<String>> graph, String node) {
        return hasCycle(graph, node, new HashSet<>());
    }

    private boolean hasCycle(Map<String, List<String>> graph, String node, Set<String> current) {
        if (current.contains(node)){
            return true;
        }

        current.add(node);
        for (String relative : graph.getOrDefault(node, List.of())) {
            if (hasCycle(graph, relative, current)) {
                return true;
            }
        }
        current.remove(node);
        return false;

    }
}
