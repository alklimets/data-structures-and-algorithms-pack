package com.aklimets.data_structures.trees.right_side_view;

import com.aklimets.data_structures.trees.TreeNode;

import java.util.*;

public class RightSideView {

    /*
        You are given the root of a binary tree. Return only the values of the nodes that are visible from the right
        side of the tree, ordered from top to bottom.

        Example 1:
        Input: root = [1,2,3]
        Output: [1,3]

        Example 2:
        Input: root = [1,2,3,4,5,6,7]
        Output: [1,3,7]

        Constraints:

        0 <= number of nodes in the tree <= 100
        -100 <= Node.val <= 100
    */

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new LinkedList<>();
        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(Map.entry(root, 1));
        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> entry = queue.poll();
            int level = entry.getValue();
            TreeNode node = entry.getKey();

            if (queue.isEmpty() || queue.peek().getValue() > level) {
                result.add(node.val);
            }

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
