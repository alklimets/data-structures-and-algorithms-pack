package com.aklimets.data_structures.graphs.topological_sort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class KahnAlgorithmUnitTest {

    public static final List<String[]> VALID_EDGE_LIST = List.of(
            new String[]{"A", "C"},
            new String[]{"B", "C"},
            new String[]{"C", "E"},
            new String[]{"C", "D"}
    );

    public static final List<String[]> INVALID_EDGE_LIST = List.of(
            new String[]{"A", "C"},
            new String[]{"B", "C"},
            new String[]{"C", "E"},
            new String[]{"C", "D"},
            new String[]{"E", "B"}
    );

    private final KahnAlgorithm cut = new KahnAlgorithm();

    @Test
    public void shouldReturnList_whenSort_givenValidGraph() {
        // given
        List<String> expected = List.of("A", "B", "C", "E", "D");

        // when
        List<String> actual = cut.sort(VALID_EDGE_LIST);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnNull_whenSort_givenInvalidGraph() {
        // given

        // when
        List<String> actual = cut.sort(INVALID_EDGE_LIST);

        // then
        assertThat(actual).isNull();
    }

}