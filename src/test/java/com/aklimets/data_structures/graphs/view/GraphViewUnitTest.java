package com.aklimets.data_structures.graphs.view;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GraphViewUnitTest {

    private static final Map<String, List<String>> ADJACENCY_LIST =  Map.of(
            "A", List.of("C"),
            "B", List.of("C"),
            "C", List.of("E", "D")
    );

    private static final List<String[]> EDGE_LIST = List.of(
            new String[]{"A", "C"},
            new String[]{"B", "C"},
            new String[]{"C", "E"},
            new String[]{"C", "D"}
    );

    private final GraphView cut = new GraphView();

    @Test
    public void shouldReturnAdjacencyList_whenToAdjacencyList_givenEdgeList() {
        //given

        // when
        Map<String, List<String>> actual = cut.toAdjacencyList(EDGE_LIST);

        // then
        assertThat(actual).isEqualTo(ADJACENCY_LIST);
    }

    @Test
    public void shouldReturnEdgeList_whenToEdgeList_givenAdjacencyList() {
        //given
        // when
        List<String[]> actual = cut.toEdgeList(ADJACENCY_LIST);

        // then
        Collections.sort(actual, Comparator.comparing(i -> i[0]));
        assertThat(actual).usingRecursiveComparison().isEqualTo(EDGE_LIST);
    }
}