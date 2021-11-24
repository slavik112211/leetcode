package com.slavik2121.leetcode.problem006;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListFindWinnerOfCircularGameTest {

    LinkedListFindWinnerOfCircularGame sut;

    @BeforeEach
    void setUp() {
        sut = new LinkedListFindWinnerOfCircularGame();
    }

    @Test
    void testLinkedListFindWinnerOfCircularGameTest1() {
        assertEquals(3, sut.findTheWinner(10, 6));

        assertEquals(1, sut.findTheWinner(6, 5));

        assertEquals(1, sut.findTheWinner(1, 1));

        assertEquals(3, sut.findTheWinner(3, 1));
    }
}