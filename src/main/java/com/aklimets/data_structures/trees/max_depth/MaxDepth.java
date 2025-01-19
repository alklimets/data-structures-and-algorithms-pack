package com.aklimets.data_structures.trees.max_depth;

import com.aklimets.data_structures.trees.TreeNode;

public class MaxDepth {

    /*
        Given the root of a binary tree, return its depth.
        The depth of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node.

        Example 1:
        Input: root = [1,2,3,null,null,4]
        Output: 3

        Example 2:
        Input: root = []
        Output: 0

        Constraints:

        0 <= The number of nodes in the tree <= 100.
        -100 <= Node.val <= 100
    */

    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
