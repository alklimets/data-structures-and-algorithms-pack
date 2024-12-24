package com.aklimets.data_structures.graphs.tasks_dependencies_validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TaskValidationUnitTest {

    private final TaskValidation cut = new TaskValidation();

    @ParameterizedTest
    @CsvFileSource(resources = "/graphs/tasks_validation.csv", numLinesToSkip = 1)
    public void shouldPerformValidation_whenValidateSequence_givenInput(String graphString, String sequence, boolean expected) {
        // given
        List<String[]> graph = Arrays.stream(graphString.split(";")).map(item -> item.split(",")).toList();

        // when
        boolean actual = cut.validateSequence(graph, sequence);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}