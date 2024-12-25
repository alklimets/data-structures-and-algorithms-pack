package com.aklimets.data_structures.graphs.dijkstra;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DijkstraUnitTest {

    private static final Map<String, Map<String, Integer>> GRAPH = Map.of(
            "A", Map.of("B", 4, "C", 2),
            "B", Map.of("C", 3, "D", 2, "E", 3),
            "C", Map.of("B", 1, "D", 4, "E", 5),
            "E", Map.of("D", 1)
    );

    private final Dijkstra cut = new Dijkstra();

    @Test
    public void shouldReturnMapOfDistances_whenSearch_givenGraphAndPointA() {
        // given
        Map<String, Integer> expected = Map.of("A", 0, "B", 3, "C", 2, "D", 5, "E", 6);

        // when
        Map<String, Integer> actual = cut.search(GRAPH, "A");

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/graphs/shortest_paths.csv", numLinesToSkip = 1)
    public void shouldReturnShortestPath_whenFindShortestPath_givenGraphAndPoints(String start, String end, String expected) {
        // given

        // when
        String actual = cut.findShortestPath(GRAPH, start, end);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}