package com.aklimets.data_structures.linkedlists;

import com.aklimets.helper.TestHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class MyLinkedListUnitTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/linkedlists/linked_lists_equals.csv", numLinesToSkip = 1)
    public void shouldReturnIsListsEqual_whenEquals_givenLists(String arra, String arrb, boolean expected) {
        // given
        MyLinkedList<Integer> givenList1 = new MyLinkedList<>(TestHelper.splitInputToList(arra));
        MyLinkedList<Integer> givenList2 = new MyLinkedList<>(TestHelper.splitInputToList(arrb));

        // when
        boolean actual = givenList1.equals(givenList2);
        
        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}