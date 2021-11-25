package com.slavik2121.leetcode.problem008;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeInvertTreeTest {

    BinaryTreeInvertTree sut;

    @BeforeEach
    void setUp() {
        sut = new BinaryTreeInvertTree();
    }

    @Test
    void testBinaryTreeInvertTree1() {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(9);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        TreeNode invertedTreeRootNode = sut.invertTree(treeNode1);

        assertEquals(treeNode1, invertedTreeRootNode);
        assertEquals(treeNode3, invertedTreeRootNode.left);
        assertEquals(treeNode2, invertedTreeRootNode.right);

        assertEquals(treeNode7, invertedTreeRootNode.left.left);
        assertEquals(treeNode6, invertedTreeRootNode.left.right);

        assertEquals(treeNode5, invertedTreeRootNode.right.left);
        assertEquals(treeNode4, invertedTreeRootNode.right.right);
    }

    @Test
    void testBinaryTreeInvertTree2() {
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        TreeNode invertedTreeRootNode = sut.invertTree(treeNode1);

        assertEquals(treeNode1, invertedTreeRootNode);
        assertEquals(treeNode3, invertedTreeRootNode.left);
        assertEquals(treeNode2, invertedTreeRootNode.right);
    }

    @Test
    void testBinaryTreeInvertTree3() {
        TreeNode treeNode1 = new TreeNode(2);

        TreeNode invertedTreeRootNode = sut.invertTree(treeNode1);

        assertEquals(treeNode1, invertedTreeRootNode);
    }

    @Test
    void testBinaryTreeInvertTree4() {
        TreeNode invertedTreeRootNode = sut.invertTree(null);

        assertEquals(null, invertedTreeRootNode);
    }
}