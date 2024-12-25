package com.aklimets.data_structures.graphs.view;

import java.util.*;

public class GraphView {

    public Map<String, List<String>> toAdjacencyList(List<String[]> relations) {
        Map<String, List<String>> result = new HashMap<>();
        for (String[] relation : relations) {
            result.computeIfAbsent(relation[0], item -> new ArrayList<>()).add(relation[1]);
        }
        return result;
    }

    public List<String[]> toEdgeList(Map<String, List<String>> adjacencyList) {
        List<String[]> result = new LinkedList<>();
        adjacencyList.forEach((edge, relatives) -> {
            for (String relative : relatives) {
                result.add(new String[]{edge, relative});
            }
        });
        return result;
    }

}
