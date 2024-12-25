package com.aklimets.data_structures.graphs.topological_sort;

import com.aklimets.data_structures.graphs.view.GraphView;

import java.util.*;
import java.util.stream.Collectors;

public class KahnAlgorithm {

    private final GraphView graphView = new GraphView();

    public List<String> sort(List<String[]> dependencies) {
        return sort(graphView.toAdjacencyList(dependencies));
    }

    public List<String> sort(Map<String, List<String>> graph) {
        Map<String, Integer> nodesWithIncomes = new HashMap<>();
        Set<String> nodes = new HashSet<>();

        graph.forEach((node, value) -> {
            for (String relative : value) {
                nodes.add(relative);
                nodes.add(node);

                if (!nodesWithIncomes.containsKey(node)) {
                    nodesWithIncomes.put(node, 0);
                }
                nodesWithIncomes.compute(relative, (k, v) -> v == null ? 1 : v + 1);
            }
        });

        List<String> result = new ArrayList<>();
        Queue<String> queue = nodesWithIncomes.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(LinkedList::new));

        while (!queue.isEmpty()) {
            String node = queue.poll();
            result.add(node);

            for (String relative : graph.getOrDefault(node, List.of())) {
                if (nodesWithIncomes.compute(relative, (k, v) -> v - 1) == 0) {
                    queue.add(relative);
                }
            }
        }

        return result.size() == nodes.size() ? result : null;
    }

}
