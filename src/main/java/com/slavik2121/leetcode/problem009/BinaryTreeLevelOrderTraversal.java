package com.slavik2121.leetcode.problem009;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * November 25, 2021
 *
 * 102. Binary Tree Level Order Traversal
 * Difficulty: Medium
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 * Input: root = [3,9,20,4,8,15,7]
 * Output: [[3],[9, 20],[4, 8, 15, 7]]
 *
 * Example 2:
 * Input: [1,2,3,4,null,null,5]
 * Output: [[1],[2,3],[4,5]]
 *
 * Example 3:
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 4:
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 *
 */
class BinaryTreeLevelOrderTraversal {

    // Breadth-first search implementation using a Queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversalNodeList = new ArrayList<>();

        /**
         * For example: nodesQueue = [
         *   [3]            // 1-st level nodes (root-level)
         *   [9, 20],       // 2-nd level nodes
         *   [4, 8, 15, 7]  // 3-rd level nodes
         * ]
         */
        Queue<List<TreeNode>> nodesQueue = new LinkedList<>();

        if(root == null) return traversalNodeList;

        List<TreeNode> currentLevelNodes = Arrays.asList(root);
        nodesQueue.add(currentLevelNodes);

        while(!nodesQueue.isEmpty()) {
            currentLevelNodes = nodesQueue.remove();
            List<TreeNode> nextLevelNodes = new ArrayList<>();

            List<Integer> currentLevelNodeValues = new ArrayList<>();
            for(TreeNode currentLevelNode: currentLevelNodes) {
                if(currentLevelNode != null) {
                    currentLevelNodeValues.add(currentLevelNode.val);

                    if(currentLevelNode.left != null) nextLevelNodes.add(currentLevelNode.left);
                    if(currentLevelNode.right != null) nextLevelNodes.add(currentLevelNode.right);
                }
            }

            if(!currentLevelNodeValues.isEmpty())
                traversalNodeList.add(currentLevelNodeValues);

            if(!nextLevelNodes.isEmpty())
                nodesQueue.add(nextLevelNodes);
        }
        return traversalNodeList;
    }
}