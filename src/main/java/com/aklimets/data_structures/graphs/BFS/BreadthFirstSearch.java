package com.aklimets.data_structures.graphs.BFS;

import java.util.*;

public class BreadthFirstSearch {

    public boolean isPathExists(String start, String finish, Map<String, List<String>> graph) {
        if (start.equals(finish)) return false;
        Queue<String> queue = new LinkedList<>();
        Set<String> checked = new HashSet<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            String item = queue.poll();
            if (item.equals(finish)) return true;
            if (checked.contains(item)) continue;
            checked.add(item);
            List<String> relatives = graph.getOrDefault(item, List.of());
            queue.addAll(relatives);
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
        Queue<Pair> queue = new LinkedList<>();
        Set<String> checked = new HashSet<>();
        queue.add(new Pair(start, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.value.equals(finish)) return current.length;
            if (checked.contains(current.value)) continue;
            checked.add(current.value);

            List<String> relatives = graph.getOrDefault(current.value, List.of());
            relatives.forEach(i -> queue.add(new Pair(i, current.length + 1)));
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
