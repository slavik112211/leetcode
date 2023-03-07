package com.slavik2121.leetcode.problem001;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonPrefixTest {

    String[] strs;
    CommonPrefix2 commonPrefix;

    @BeforeEach
    void setUp() {
        commonPrefix = new CommonPrefix2();
    }

    @Test
    void testLongestCommonPrefix() {
        strs = new String[]{"flower","flow","flight"};
        assertEquals("fl", commonPrefix.longestCommonPrefix(strs));

        strs = new String[]{"flow","flow","flow"};
        assertEquals("flow", commonPrefix.longestCommonPrefix(strs));

        strs = new String[]{"flight"};
        assertEquals("flight", commonPrefix.longestCommonPrefix(strs));

        strs = new String[]{""};
        assertEquals("", commonPrefix.longestCommonPrefix(strs));

        strs = new String[]{"flower","flow"};
        assertEquals("flow", commonPrefix.longestCommonPrefix(strs));

        strs = new String[]{"dog","racecar","car"};
        assertEquals("", commonPrefix.longestCommonPrefix(strs));
    }
}