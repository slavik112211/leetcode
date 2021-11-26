package com.slavik2121.leetcode.problem010;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KthLargestTest {

    KthLargest sut;

    @Test
    void testBinaryTreeLevelOrderTraversal1() {
        sut = new KthLargest(3, new int[]{4,5,8,2});
        assertEquals(4, sut.add(3));
        assertEquals(5, sut.add(5));
        assertEquals(5, sut.add(10));
        assertEquals(8, sut.add(9));
        assertEquals(8, sut.add(4));
    }
}