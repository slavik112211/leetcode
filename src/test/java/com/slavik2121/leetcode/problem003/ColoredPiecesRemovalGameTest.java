package com.slavik2121.leetcode.problem003;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColoredPiecesRemovalGameTest {

    String input;
    ColoredPiecesRemovalGame2 sut;

    @BeforeEach
    void setUp() {
        sut = new ColoredPiecesRemovalGame2();
    }

    @Test
    void testColoredPiecesRemovalGame() {
        input = "AAABABB";
        assertEquals(true, sut.winnerOfGame(input));

        input = "AA";
        assertEquals(false, sut.winnerOfGame(input));

        input = "ABBBBBBBAAA";
        assertEquals(false, sut.winnerOfGame(input));

        input = "AAABAAABBB";
        assertEquals(true, sut.winnerOfGame(input));
    }
}
