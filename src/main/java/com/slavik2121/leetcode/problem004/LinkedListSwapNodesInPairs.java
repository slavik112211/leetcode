package com.slavik2121.leetcode.problem004;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * November 22, 2021
 *
 * 24. Swap Nodes in Pairs
 * Difficulty: Medium
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Example 2:
 *
 * Input: head = []
 * Output: []
 *
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
class LinkedListSwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // initial pair swap
        ListNode lhs = head;
        ListNode rhs = head.next;
        lhs.next = rhs.next;
        rhs.next = lhs;
        head = rhs;
        ListNode preLHS = lhs;

        // consequent pair swaps
        while(preLHS.next != null && preLHS.next.next != null) {
            lhs = preLHS.next;
            rhs = preLHS.next.next;

            preLHS.next = rhs;
            lhs.next = rhs.next;
            rhs.next = lhs;
            preLHS = lhs;
        }

        return head;
    }
}