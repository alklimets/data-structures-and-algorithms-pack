package com.aklimets.algorithms.dynamic_programming.neetcode.min_cost_climbing_stairs;

import com.aklimets.helper.TestHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

class MinCostClimbingStairsUnitTest {

    private final MinCostClimbingStairs cut = new MinCostClimbingStairs();

    @ParameterizedTest
    @CsvFileSource(resources = "/dynamic_programming/min_costs_climbing_stairs.csv", numLinesToSkip = 1)
    public void shouldPassTest_whenClimbStairs_givenInput(String input, int expected) {
        // given
        int[] costs = TestHelper.splitInputToArray(input);

        // when
        long actual = cut.minCostClimbingStairs(costs);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}