package com.aklimets.algorithms.greedy.minimum_stations;

import java.util.*;

public class MinimumStations {

    public List<String> solve(Set<String> statesGiven, Map<String, Set<String>> stationsGiven) {
        List<String> result = new ArrayList<>();
        Set<String> states = new HashSet<>(statesGiven);
        Map<String, Set<String>> stations = new HashMap<>(stationsGiven);

        while(states.size() > 0) {
            Map.Entry<String, Set<String>> maxCoverageEntry = stations.entrySet()
                    .stream()
                    .max(Comparator.comparingLong(entry -> entry.getValue().stream().filter(states::contains).count()))
                    .get();
            states.removeAll(maxCoverageEntry.getValue());
            stations.remove(maxCoverageEntry.getKey());
            result.add(maxCoverageEntry.getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        Set<String> states = Set.of("WA", "MT", "ID", "OR", "NV", "UT", "CA", "AZ");
        Map<String, Set<String>> stations = Map.of(
                "1", Set.of("ID", "NV", "UT"),
                "2", Set.of("ID", "WA", "MT"),
                "3", Set.of("OR", "NV", "CA"),
                "4", Set.of("NV", "UT"),
                "5", Set.of("CA", "AZ")
        );

        System.out.println(new MinimumStations().solve(states, stations));
    }
}
