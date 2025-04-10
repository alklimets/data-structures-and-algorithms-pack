package com.aklimets.data_structures.graphs.bellman_ford;

import com.aklimets.data_structures.graphs.dijkstra.Dijkstra;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BellmanFord {

    public Map<String, Integer> solve(List<String[]> graph, String start) {
        List<String> nodes = graph.stream().flatMap(pair -> Stream.of(pair[0], pair[1])).distinct().toList();
        Map<String, Integer> weights = nodes.stream().collect(Collectors.toMap(Function.identity(), i -> Integer.MAX_VALUE));
        weights.put(start, 0);

        for (int i = 1;  i < nodes.size(); i++) {
            for (String[] edge : graph) {
                if (weights.get(edge[0]) != Integer.MAX_VALUE && weights.get(edge[0]) + Integer.parseInt(edge[2]) < weights.get(edge[1])) {
                    weights.put(edge[1], weights.get(edge[0]) + Integer.parseInt(edge[2]));
                }
            }
        }

        for (String[] edge : graph) {
            int newWeight = weights.get(edge[0]) + Integer.parseInt(edge[2]);
            if (weights.get(edge[0]) != Integer.MAX_VALUE && newWeight < weights.get(edge[1])) {
                throw new IllegalArgumentException("Negative cycle");
            }
        }

        return weights;
    }

    public static void main(String[] args) {
        System.out.println(new BellmanFord().solve(
                List.of(
                        new String[]{"A", "B", "4"},
                        new String[]{"A", "C", "2"},
                        new String[]{"B", "D", "2"},
                        new String[]{"B", "E", "3"},
                        new String[]{"B", "C", "3"},
                        new String[]{"C", "B", "1"},
                        new String[]{"C", "D", "4"},
                        new String[]{"C", "E", "5"},
                        new String[]{"E", "D", "1"}
                ),
                "A"
        ));
        System.out.println(new BellmanFord().solve(
                List.of(
                        new String[] { "A", "B", "4" },
                        new String[] { "A", "C", "2" },
                        new String[] { "C", "B", "-2" },
                        new String[] { "B", "D", "2" },
                        new String[] { "C", "E", "3" },
                        new String[] { "E", "D", "-1" }
                ),
                "A"
        ));
//        System.out.println(new BellmanFord().solve(
//                List.of(
//                        new String[] { "A", "B", "1" },
//                        new String[] { "B", "C", "-2" },
//                        new String[] { "C", "D", "1" },
//                        new String[] { "D", "B", "-1" },   // This creates a cycle: B → C → D → B
//                        new String[] { "A", "E", "4" }
//                ),
//                "A"
//        ));


    }
}
