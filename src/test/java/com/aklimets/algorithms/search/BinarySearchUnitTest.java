package com.aklimets.algorithms.search;

import com.aklimets.data_structures.arrays.search.BinarySearch;
import com.aklimets.helper.TestHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchUnitTest {

    private final BinarySearch cut = new BinarySearch();

    @ParameterizedTest
    @CsvFileSource(resources = "/arrays/search/search_array.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenSearch_given_input(String input, int item, int expected) {
        // given
        int[] givenInput = TestHelper.splitInput(input);

        // when
        int actual = cut.search(givenInput, item);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}