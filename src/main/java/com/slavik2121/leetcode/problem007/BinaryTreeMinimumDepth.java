package com.slavik2121.leetcode.problem007;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * November 24, 2021
 *
 * 111. Minimum Depth of Binary Tree
 * Difficulty: Easy
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 *
 * Example 2:
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 */
class BinaryTreeMinimumDepth {

    // depth-first search for a leaf node
    public int minDepth(TreeNode node) {
        if(node == null) return 0;

        int shortestPathCurrentNode = 1;

        if(isLeafNode(node)) return shortestPathCurrentNode;

        int shortestPathLeftChild = minDepth(node.left);
        int shortestPathRightChild = minDepth(node.right);

        if(shortestPathLeftChild == 0) {
            return shortestPathCurrentNode + shortestPathRightChild;
        } else if(shortestPathRightChild == 0) {
            return shortestPathCurrentNode + shortestPathLeftChild;
        } else {
            return shortestPathCurrentNode +
                    ((shortestPathLeftChild < shortestPathRightChild) ?
                    shortestPathLeftChild : shortestPathRightChild);
        }
    }

    // A leaf is a node with no children.
    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}