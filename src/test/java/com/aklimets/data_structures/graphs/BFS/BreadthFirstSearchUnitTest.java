package com.aklimets.data_structures.graphs.BFS;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BreadthFirstSearchUnitTest {

    private BreadthFirstSearch cut = new BreadthFirstSearch();

    private static Map<String, List<String>> graph = Map.of(
            "A", List.of("B", "C"),
            "B", List.of("E", "D"),
            "C", List.of("D", "F"),
            "F", List.of("G"),
            "D", List.of("F")
    );

    @Test
    public void shouldReturnTrue_whenIsPathExists_givenAAndG() {
        // given

        // when
        boolean actual = cut.isPathExists("A", "G", graph);

        // then
        assertThat(actual).isTrue();
    }

    @Test
    public void shouldReturnFalse_whenIsPathExists_givenACndE() {
        // given

        // when
        boolean actual = cut.isPathExists("C", "E", graph);

        // then
        assertThat(actual).isFalse();
    }

    @Test
    public void shouldReturn3_whenShortestPath_givenAAndG() {
        // given

        // when
        int actual = cut.shortestPath("A", "G", graph);

        // then
        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void shouldReturn0_whenShortestPath_givenAAndA() {
        // given

        // when
        int actual = cut.shortestPath("A", "A", graph);

        // then
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void shouldReturnNegative1_whenShortestPath_givenACndE() {
        // given

        // when
        int actual = cut.shortestPath("C", "E", graph);

        // then
        assertThat(actual).isEqualTo(-1);
    }


    @Test
    public void shouldReturnACFG_whenShortestPathValue_givenAAndG() {
        // given

        // when
        String actual = cut.shortestPathValue("A", "G", graph);

        // then
        assertThat(actual).isEqualTo("ACFG");
    }

    @Test
    public void shouldReturnA_whenShortestPathValue_givenAAndA() {
        // given

        // when
        String actual = cut.shortestPathValue("A", "A", graph);

        // then
        assertThat(actual).isEqualTo("A");
    }

    @Test
    public void shouldReturnEmptyString_whenShortestPathValue_givenACndE() {
        // given

        // when
        String actual = cut.shortestPathValue("C", "E", graph);

        // then
        assertThat(actual).isEmpty();
    }

}