package com.aklimets.data_structures.trees.level_order_traversal;

import com.aklimets.data_structures.trees.TreeNode;

import java.util.*;

public class LevelOrderTraversal {

    /*
        Given a binary tree root, return the level order traversal of it as a nested list, where each sublist contains the values of nodes at a particular level in the tree, from left to right.

        Example 1:
        Input: root = [1,2,3,4,5,6,7]
        Output: [[1],[2,3],[4,5,6,7]]

        Example 2:
        Input: root = [1]
        Output: [[1]]

        Example 3:
        Input: root = []
        Output: []

        Constraints:

        0 <= The number of nodes in both trees <= 1000.
        -1000 <= Node.val <= 1000
    */

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(Map.entry(root, 1));
        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> entry = queue.poll();
            int level = entry.getValue();
            TreeNode node = entry.getKey();

            if (result.size() < level) {
                result.add(new ArrayList<>());
            }
            result.get(level - 1).add(node.val);
            if (node.left != null) {
                queue.offer(Map.entry(node.left, level + 1));
            }

            if (node.right != null) {
                queue.offer(Map.entry(node.right, level + 1));
            }
        }
        return result;
    }
}
