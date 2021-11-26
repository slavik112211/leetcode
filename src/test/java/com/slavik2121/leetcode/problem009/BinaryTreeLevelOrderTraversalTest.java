package com.slavik2121.leetcode.problem009;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeLevelOrderTraversalTest {

    BinaryTreeLevelOrderTraversal sut;

    @BeforeEach
    void setUp() {
        sut = new BinaryTreeLevelOrderTraversal();
    }

    @Test
    void testBinaryTreeLevelOrderTraversal1() {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        List<List<Integer>> traversalNodeList = sut.levelOrder(treeNode1);

        List<List<Integer>> traversalNodeListExpected =
                Arrays.asList(
                        Arrays.asList(3),
                        Arrays.asList(9, 20),
                        Arrays.asList(4, 8, 15, 7)
                );

        assertEquals(traversalNodeListExpected, traversalNodeList);
    }

    @Test
    void testBinaryTreeLevelOrderTraversal2() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;

        List<List<Integer>> traversalNodeList = sut.levelOrder(treeNode1);

        List<List<Integer>> traversalNodeListExpected =
                Arrays.asList(
                        Arrays.asList(1),
                        Arrays.asList(2, 3),
                        Arrays.asList(4, 5)
                );

        assertEquals(traversalNodeListExpected, traversalNodeList);
    }

    @Test
    void testBinaryTreeLevelOrderTraversal3() {
        TreeNode treeNode1 = new TreeNode(1);

        List<List<Integer>> traversalNodeList = sut.levelOrder(treeNode1);

        List<List<Integer>> traversalNodeListExpected =
                Arrays.asList(
                        Arrays.asList(1)
                );

        assertEquals(traversalNodeListExpected, traversalNodeList);
    }

    @Test
    void testBinaryTreeLevelOrderTraversal4() {
        List<List<Integer>> traversalNodeList = sut.levelOrder(null);
        List<List<Integer>> traversalNodeListExpected = new ArrayList<>();
        assertEquals(traversalNodeListExpected, traversalNodeList);
    }
}