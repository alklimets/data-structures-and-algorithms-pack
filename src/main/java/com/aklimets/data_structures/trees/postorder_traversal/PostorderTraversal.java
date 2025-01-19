package com.aklimets.data_structures.trees.postorder_traversal;

import com.aklimets.data_structures.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    /*
        Given the root of a binary tree, return the postorder traversal of its nodes' values.

        Example 1:
        Input: root = [1,null,2,3]
        Output: [3,2,1]

        Example 2:
        Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
        Output: [4,6,7,5,2,9,8,3,1]

        Example 3:
        Input: root = []
        Output: []

        Example 4:
        Input: root = [1]
        Output: [1]

        Constraints:
        The number of the nodes in the tree is in the range [0, 100].
        -100 <= Node.val <= 100

        Follow up: Recursive solution is trivial, could you do it iteratively?
    */

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                nodes.add(node.val);
                continue;
            }
            stack.push(new TreeNode(node.val));
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return nodes;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traversal(root, nodes);
        return nodes;
    }

    private void traversal(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        traversal(root.left, nodes);
        traversal(root.right, nodes);
        nodes.add(root.val);
    }
}
