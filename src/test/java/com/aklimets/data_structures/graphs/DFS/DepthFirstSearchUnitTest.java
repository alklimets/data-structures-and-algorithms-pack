package com.aklimets.data_structures.graphs.DFS;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DepthFirstSearchUnitTest {

    private static Map<String, List<String>> graphWithCycle = Map.of(
            "A", List.of("B"),
            "B", List.of("C"),
            "C", List.of("A")
    );

    private static Map<String, List<String>> graphWithoutCycle = Map.of(
            "A", List.of("B", "C"),
            "B", List.of("E", "D"),
            "C", List.of("D", "F"),
            "F", List.of("G"),
            "D", List.of("F")
    );

    private final DepthFirstSearch cut = new DepthFirstSearch();


    @Test
    public void shouldReturnTrue_whenHasCycle_givenGraphWithCycle() {
        // given

        // when
        boolean actual = cut.hasCycle(graphWithCycle, "A");

        // then
        assertThat(actual).isTrue();
    }
    @Test
    public void shouldReturnFalse_whenHasCycle_givenGraphWithoutCycle() {
        // given

        // when
        boolean actual = cut.hasCycle(graphWithoutCycle, "A");

        // then
        assertThat(actual).isFalse();
    }

}