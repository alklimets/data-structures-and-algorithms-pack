package com.aklimets.algorithms.dynamic_programming.neetcode.house_robber;

import com.aklimets.helper.TestHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class HouseRobberUnitTest {

    private final HouseRobber cut = new HouseRobber();

    @ParameterizedTest
    @CsvFileSource(resources = "/dynamic_programming/house_robber.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenRob_givenInput(String input, int expected) {
        // given
        int[] costs = TestHelper.splitInputToArray(input);

        // when
        long actual = cut.rob(costs);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dynamic_programming/house_robber.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenRob2_givenInput(String input, int expected) {
        // given
        int[] costs = TestHelper.splitInputToArray(input);

        // when
        long actual = cut.rob2(costs);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}