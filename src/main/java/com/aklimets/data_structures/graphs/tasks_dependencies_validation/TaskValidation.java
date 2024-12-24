package com.aklimets.data_structures.graphs.tasks_dependencies_validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskValidation {

    public boolean validateSequence(List<String[]> graph, String sequence) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = sequence.chars().mapToObj(item -> String.valueOf((char) item)).toList();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        return graph.stream().noneMatch(pair -> map.getOrDefault(pair[0], Integer.MAX_VALUE) < map.getOrDefault(pair[1], Integer.MAX_VALUE));
    }
}
