package com.slavik2121.leetcode.problem007;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeMinimumDepthTest {

    BinaryTreeMinimumDepth sut;

    @BeforeEach
    void setUp() {
        sut = new BinaryTreeMinimumDepth();
    }

    @Test
    void testBinaryTreeMinimumDepth1() {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        assertEquals(2, sut.minDepth(treeNode1));
    }

    @Test
    void testBinaryTreeMinimumDepth2() {
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);

        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;
        treeNode3.right = treeNode4;
        treeNode4.right = treeNode5;

        assertEquals(5, sut.minDepth(treeNode1));
    }
}