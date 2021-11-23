package com.slavik2121.leetcode.problem004;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListSwapNodesInPairsTest {

    LinkedListSwapNodesInPairs sut;

    @BeforeEach
    void setUp() {
        sut = new LinkedListSwapNodesInPairs();
    }

    @Test
    void testLinkedListSwapNodesInPairs1() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;

        ListNode outputHeadNode = sut.swapPairs(listNode1);

        assertEquals(2, outputHeadNode.val);
        assertEquals(1, outputHeadNode.next.val);
        assertEquals(4, outputHeadNode.next.next.val);
        assertEquals(3, outputHeadNode.next.next.next.val);
        assertEquals(6, outputHeadNode.next.next.next.next.val);
        assertEquals(5, outputHeadNode.next.next.next.next.next.val);
        assertEquals(8, outputHeadNode.next.next.next.next.next.next.val);
        assertEquals(7, outputHeadNode.next.next.next.next.next.next.next.val);
    }

    @Test
    void testLinkedListSwapNodesInPairs2() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode outputHeadNode = sut.swapPairs(listNode1);

        assertEquals(2, outputHeadNode.val);
        assertEquals(1, outputHeadNode.next.val);
        assertEquals(4, outputHeadNode.next.next.val);
        assertEquals(3, outputHeadNode.next.next.next.val);
        assertEquals(5, outputHeadNode.next.next.next.next.val);
    }

    @Test
    void testLinkedListSwapNodesInPairs3() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;

        ListNode outputHeadNode = sut.swapPairs(listNode1);

        assertEquals(2, outputHeadNode.val);
        assertEquals(1, outputHeadNode.next.val);
    }


    @Test
    void testLinkedListSwapNodesInPairs4() {
        ListNode listNode1 = new ListNode(1);

        ListNode outputHeadNode = sut.swapPairs(listNode1);

        assertEquals(1, outputHeadNode.val);
        assertEquals(null, outputHeadNode.next);
    }

    @Test
    void testLinkedListSwapNodesInPairs5() {
        ListNode outputHeadNode = sut.swapPairs(null);

        assertEquals(null, outputHeadNode);
    }
}