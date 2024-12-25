package com.aklimets.data_structures.graphs.topological_sort;

import com.aklimets.data_structures.graphs.view.GraphView;

import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSort {

    public String sort(List<String[]> dependencies) {
        Map<String, List<String>> graph = new GraphView().toAdjacencyList(dependencies);
        Map<String, Integer> nodesWithIncomes = new HashMap<>();
        for (String[] dependency : dependencies) {
            if (!nodesWithIncomes.containsKey(dependency[0])) {
                nodesWithIncomes.put(dependency[0], 0);
            }
            nodesWithIncomes.compute(dependency[1], (k, v) -> v == null ? 1 : v + 1);
        }

        List<String> result = new ArrayList<>();
        Queue<String> queue = nodesWithIncomes.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(LinkedList::new));

        while (!queue.isEmpty()) {
            String node = queue.poll();
            result.add(node);

            if (graph.containsKey(node)) {
                for (String relative : graph.get(node)) {
                    nodesWithIncomes.compute(relative, (k, v) -> v - 1);
                    if (nodesWithIncomes.get(relative) == 0) {
                        queue.add(relative);
                    }
                }
            }
        }

        return String.join("", result);
    }

    public static void main(String[] args) {
        System.out.println(new TopologicalSort().sort(List.of(
                new String[]{"A", "B"},
                new String[]{"A", "C"},
                new String[]{"B", "D"},
                new String[]{"C", "D"},
                new String[]{"E", "B"}
        )));
    }
}
