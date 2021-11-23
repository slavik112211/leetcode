package com.slavik2121.leetcode.problem002;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecryptStringTest {

    String str;
    DecryptString decryptString;

    @BeforeEach
    void setUp() {
        decryptString = new DecryptString();
    }

    @Test
    void testDecryptString() {
        str = "10#11#12";
        assertEquals("jkab", decryptString.freqAlphabets(str));

        str = "1326#";
        assertEquals("acz", decryptString.freqAlphabets(str));

        str = "25#";
        assertEquals("y", decryptString.freqAlphabets(str));

        str = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        assertEquals("abcdefghijklmnopqrstuvwxyz", decryptString.freqAlphabets(str));
    }
}