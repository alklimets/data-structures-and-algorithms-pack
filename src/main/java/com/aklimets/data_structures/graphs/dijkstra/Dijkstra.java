package com.aklimets.data_structures.graphs.dijkstra;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Dijkstra {

    public Map<String, Integer> search(Map<String, Map<String, Integer>> graph, String start) {
        Map<String, Integer> result = graph.keySet().stream().collect(Collectors.toMap(Function.identity(), a -> Integer.MAX_VALUE));
        result.put(start, 0);

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        queue.offer(new AbstractMap.SimpleEntry<>(start, 0));

        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Map.Entry<String, Integer> entry = queue.poll();
            String node = entry.getKey();
            Integer weight = entry.getValue();

            if (visited.contains(node)) {
                continue;
            } else {
                visited.add(node);
            }

            Map<String, Integer> relatives = graph.getOrDefault(node, new HashMap<>());
            for (Map.Entry<String, Integer> relativeNode : relatives.entrySet()) {
                String relative = relativeNode.getKey();
                Integer relativeWeight = relativeNode.getValue();

                int currentRelativePathWeight = result.getOrDefault(relative, Integer.MAX_VALUE);
                int offeredWeight = weight + relativeWeight;
                if (weight + relativeWeight < currentRelativePathWeight) {
                    result.put(relative, offeredWeight);
                    queue.offer(new AbstractMap.SimpleEntry<>(relative, result.getOrDefault(relative, Integer.MAX_VALUE)));
                }

            }
        }

        return result;
    }

    public String findShortestPath(Map<String, Map<String, Integer>> graph, String start, String end) {
        Map<String, Integer> result = graph.keySet().stream().collect(Collectors.toMap(Function.identity(), a -> Integer.MAX_VALUE));
        result.put(start, 0);
        Map<String, String> parents = graph.keySet().stream().collect(Collectors.toMap(Function.identity(), a -> ""));

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        queue.offer(new AbstractMap.SimpleEntry<>(start, 0));

        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Map.Entry<String, Integer> entry = queue.poll();
            String node = entry.getKey();
            Integer weight = entry.getValue();

            if (visited.contains(node)) {
                continue;
            } else {
                visited.add(node);
            }

            Map<String, Integer> relatives = graph.getOrDefault(node, new HashMap<>());
            for (Map.Entry<String, Integer> relativeNode : relatives.entrySet()) {
                String relative = relativeNode.getKey();
                Integer relativeWeight = relativeNode.getValue();

                int currentRelativePathWeight = result.getOrDefault(relative, Integer.MAX_VALUE);
                int offeredWeight = weight + relativeWeight;
                if (weight + relativeWeight < currentRelativePathWeight) {
                    result.put(relative, offeredWeight);
                    parents.put(relative, node);
                    queue.offer(new AbstractMap.SimpleEntry<>(relative, result.getOrDefault(relative, Integer.MAX_VALUE)));
                }

            }
        }
        StringBuilder path = new StringBuilder();
        while (!end.equals(start)) {
            path.append(end);
            end = parents.get(end);
        }
        path.append(start);

        return path.reverse().toString();
    }
}
