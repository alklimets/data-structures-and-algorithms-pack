package com.aklimets.data_structures.trees.preorder_traversal;

import com.aklimets.data_structures.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    /*
        Given the root of a binary tree, return the preorder traversal of its nodes' values.

        Example 1:
        Input: root = [1,null,2,3]
        Output: [1,2,3]

        Example 2:
        Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
        Output: [1,2,4,5,6,7,3,8,9]

        Example 3:
        Input: root = []
        Output: []

        Example 4:
        Input: root = [1]
        Output: [1]

        Constraints:

        The number of nodes in the tree is in the range [0, 100].
        -100 <= Node.val <= 100

        Follow up: Recursive solution is trivial, could you do it iteratively?
    */

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            nodes.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return nodes;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traversal(root, nodes);
        return nodes;
    }

    private void traversal(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        nodes.add(root.val);
        traversal(root.left, nodes);
        traversal(root.right, nodes);
    }
}
