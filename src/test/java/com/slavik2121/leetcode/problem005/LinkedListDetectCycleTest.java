package com.slavik2121.leetcode.problem005;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListDetectCycleTest {

    LinkedListDetectCycle sut;

    @BeforeEach
    void setUp() {
        sut = new LinkedListDetectCycle();
    }

    @Test
    void testLinkedListDetectCycle1() {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        assertEquals(true, sut.hasCycle(listNode1));
        assertEquals(listNode2, sut.detectCycle(listNode1));
    }

    @Test
    void testLinkedListDetectCycle2() {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        assertEquals(false, sut.hasCycle(listNode1));
        assertEquals(null, sut.detectCycle(listNode1));
    }

    @Test
    void testLinkedListDetectCycle3() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode1;

        assertEquals(true, sut.hasCycle(listNode1));
        assertEquals(listNode1, sut.detectCycle(listNode1));
    }

    @Test
    void testLinkedListDetectCycle4() {
        ListNode listNode1 = new ListNode(1);

        assertEquals(false, sut.hasCycle(listNode1));
        assertEquals(null, sut.detectCycle(listNode1));
    }

    @Test
    void testLinkedListDetectCycle5() {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = listNode1;

        assertEquals(true, sut.hasCycle(listNode1));
        assertEquals(listNode1, sut.detectCycle(listNode1));
    }
}