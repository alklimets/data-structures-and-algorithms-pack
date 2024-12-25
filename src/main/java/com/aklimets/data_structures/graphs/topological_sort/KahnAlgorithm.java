package com.aklimets.data_structures.graphs.topological_sort;

import com.aklimets.data_structures.graphs.view.GraphView;

import java.util.*;
import java.util.stream.Collectors;

public class KahnAlgorithm {

    public List<String> sort(List<String[]> dependencies) {
        Map<String, List<String>> graph = new GraphView().toAdjacencyList(dependencies);
        Map<String, Integer> nodesWithIncomes = new HashMap<>();
        Set<String> nodes = new HashSet<>();
        for (String[] dependency : dependencies) {
            nodes.add(dependency[0]);
            nodes.add(dependency[1]);

            if (!nodesWithIncomes.containsKey(dependency[0])) {
                nodesWithIncomes.put(dependency[0], 0);
            }
            nodesWithIncomes.compute(dependency[1], (item, count) -> count == null ? 1 : count + 1);
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

            for (String relative : graph.getOrDefault(node, List.of())) {
                nodesWithIncomes.compute(relative, (k, v) -> v - 1);
                if (nodesWithIncomes.get(relative) == 0) {
                    queue.add(relative);
                }
            }
            System.out.println();
        }

        return result.size() == nodes.size() ? result : null;
    }

}
