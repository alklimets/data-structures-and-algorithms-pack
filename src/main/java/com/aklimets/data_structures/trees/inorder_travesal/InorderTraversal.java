package com.aklimets.data_structures.trees.inorder_travesal;

import com.aklimets.data_structures.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    /*
        Given the root of a binary tree, return the inorder traversal of its nodes' values.

        Example 1:
        Input: root = [1,null,2,3]
        Output: [1,3,2]

        Example 2:
        Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
        Output: [4,2,6,5,7,1,3,9,8]

        Example 3:
        Input: root = []
        Output: []

        Example 4:
        Input: root = [1]
        Output: [1]
    */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traversal(root, nodes);
        return nodes;
    }

    private void traversal(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        traversal(root.left, nodes);
        nodes.add(root.val);
        traversal(root.right, nodes);
    }

}
