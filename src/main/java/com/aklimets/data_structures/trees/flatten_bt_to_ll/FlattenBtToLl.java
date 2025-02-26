package com.aklimets.data_structures.trees.flatten_bt_to_ll;

import com.aklimets.data_structures.trees.TreeNode;

public class FlattenBtToLl {

    /*
        Given the root of a binary tree, flatten the tree into a "linked list":
        The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
        The "linked list" should be in the same order as a pre-order traversal of the binary tree.

        Example 1:
        Input: root = [1,2,5,3,4,null,6]
        Output: [1,null,2,null,3,null,4,null,5,null,6]

        Example 2:
        Input: root = []
        Output: []

        Example 3:
        Input: root = [0]
        Output: [0]

        Constraints:

        The number of nodes in the tree is in the range [0, 2000].
        -100 <= Node.val <= 100
    */

    public void flatten(TreeNode root) {
        traversal(root);
    }

    TreeNode traversal(TreeNode root) {
        if (root == null) return null;

        TreeNode left = traversal(root.left);
        if (left != null) {
            TreeNode tail = left;
            while (tail.right != null) {
                tail = tail.right;
            }
            tail.right = root.right;
            root.right = left;
        }

        root.left = null;
        traversal(root.right);

        return root;
    }
}
