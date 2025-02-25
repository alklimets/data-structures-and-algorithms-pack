package com.aklimets.data_structures.graphs.dijkstra;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Dijkstra {

    public Map<String, Integer> search(Map<String, Map<String, Integer>> graph, String start) {
        Map<String, Integer> result = new HashMap<>();
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
            }

            visited.add(node);
            graph.getOrDefault(node, new HashMap<>()).forEach((relative, relWeight) -> {
                int offeredWeight = weight + relWeight;
                int actualRelativeWeight = result.getOrDefault(relative, Integer.MAX_VALUE);
                if (offeredWeight < actualRelativeWeight) {
                    result.put(relative, offeredWeight);
                    queue.offer(new AbstractMap.SimpleEntry<>(relative, offeredWeight));
                }
            });
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

    public String findShortestPath2(Map<String, List<Pair<String, Integer>>> graph, String start, String end) {
        if (start.equals(end)) return start;
        Map<String, String> parents = new HashMap<>();
        Map<String, Integer> weights = graph.keySet().stream().collect(Collectors.toMap(Function.identity(), i -> Integer.MAX_VALUE));

        Queue<Pair<String, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        Set<String> visited = new HashSet<>();
        queue.offer(Pair.of(start, 0));
        weights.put(start, 0);

        while (!queue.isEmpty()) {
            Pair<String, Integer> poll = queue.poll();
            String parent = poll.getKey();
            int weight = poll.getValue();

            if (!visited.add(parent)) continue;

            for (Pair<String, Integer> relativePair : graph.getOrDefault(parent, List.of())) {
                String relative = relativePair.getKey();
                int relativeWeight = relativePair.getValue();

                if (weight + relativeWeight < weights.getOrDefault(relative, Integer.MAX_VALUE)) {
                    weights.put(relative, weight + relativeWeight);
                    queue.offer(Pair.of(relative, weight + relativeWeight));
                    parents.put(relative, parent);
                }
            }
        }

        LinkedList<String> result = new LinkedList<>();
        while (end != null) {
            result.addFirst(end);
            end = parents.get(end);
        }

        return String.join("->", result);
    }

    public static void main(String[] args) {
        System.out.println(new Dijkstra().findShortestPath2(
                Map.of(
                        "A", List.of(Pair.of("B", 4), Pair.of("C", 2)),
                        "B", List.of(Pair.of("D", 2), Pair.of("E", 3), Pair.of("C", 3)),
                        "C", List.of(Pair.of("B", 1), Pair.of("D", 4), Pair.of("E", 5)),
                        "E", List.of(Pair.of("D", 1)),
                        "D", List.of()
                ),
                "A",
                "E"
        ));
    }
}
