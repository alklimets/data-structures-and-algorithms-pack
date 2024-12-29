package com.aklimets.algorithms.dynamic_programming.neetcode.house_robber2;

import com.aklimets.helper.TestHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class HouseRobber2UnitTest {

    private final HouseRobber2 cut = new HouseRobber2();

    @ParameterizedTest
    @CsvFileSource(resources = "/dynamic_programming/house_robber2.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenRob_givenInput(String input, int expected) {
        // given
        int[] costs = TestHelper.splitInputToArray(input);

        // when
        long actual = cut.rob(costs);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}