package com.aklimets.data_structures.graphs.DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DepthFirstSearch {

    public boolean hasCycle(Map<String, List<String>> graph, String node) {
        return hasCycle(graph, node, new LinkedList<>());
    }

    private boolean hasCycle(Map<String, List<String>> graph, String node, LinkedList<String> stack) {
        if (!graph.containsKey(node)) {
            return false;
        }
        if (stack.contains(node)){
            return true;
        }

        List<String> relatives = graph.get(node);
        stack.addLast(node);
        for (String relative : relatives) {
            if (hasCycle(graph, relative, stack)) {
                return true;
            }
        }
        stack.removeLast();
        return false;

    }
}
