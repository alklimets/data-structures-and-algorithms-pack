package com.aklimets.data_structures.graphs.BFS;

import java.util.*;

public class BreadthFirstSearch {

    public boolean isPathExists(String start, String finish, Map<String, List<String>> graph) {
        if (start.equals(finish)) return false;
        Queue<String> queue = new LinkedList<>();
        Set<String> checked = new HashSet<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (checked.contains(node)) continue;
            if (node.equals(finish)) return true;
            checked.add(node);
            queue.addAll(graph.getOrDefault(node, List.of()));
        }
        return false;
    }


    private static class Pair {
        String value;
        int length;

        public Pair(String value, int length) {
            this.value = value;
            this.length = length;
        }
    }

    public int shortestPath(String start, String finish, Map<String, List<String>> graph) {
        if (start.equals(finish)) return 0;
        Queue<Pair> queue = new LinkedList<>();
        Set<String> checked = new HashSet<>();
        queue.add(new Pair(start, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.value.equals(finish)) return pair.length;
            if (checked.contains(pair.value)) continue;
            checked.add(pair.value);
            graph.getOrDefault(pair.value, List.of()).forEach(item -> queue.add(new Pair(item, pair.length + 1)));
        }
        return -1;
    }



    private static class PathPair {
        String value;
        String path;

        public PathPair(String value, String path) {
            this.value = value;
            this.path = path;
        }
    }

    public String shortestPathValue(String start, String finish, Map<String, List<String>> graph) {
        Queue<PathPair> queue = new LinkedList<>();
        Set<String> checked = new HashSet<>();
        queue.add(new PathPair(start, start));

        while (!queue.isEmpty()) {
            PathPair current = queue.poll();
            if (current.value.equals(finish)) return current.path;
            if (checked.contains(current.value)) continue;
            checked.add(current.value);

            List<String> relatives = graph.getOrDefault(current.value, List.of());
            relatives.forEach(i -> queue.add(new PathPair(i, current.path + i)));
        }
        return "";
    }

}
