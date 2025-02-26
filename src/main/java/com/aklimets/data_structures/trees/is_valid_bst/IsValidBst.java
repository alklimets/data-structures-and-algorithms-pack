package com.aklimets.data_structures.trees.is_valid_bst;

import com.aklimets.data_structures.trees.TreeNode;

public class IsValidBst {

    /*
        Given the root of a binary tree, determine if it is a valid binary search tree (BST).
        A valid BST is defined as follows:
        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.

        Example 1:
        Input: root = [2,1,3]
        Output: true

        Example 2:
        Input: root = [5,1,4,null,null,3,6]
        Output: false

        Explanation: The root node's value is 5 but its right child's value is 4.

        Constraints:

        The number of nodes in the tree is in the range [1, 104].
        -2^31 <= Node.val <= 2^31 - 1
    */

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (isSmallerInvalid(root.left, root.val) || isGreaterInvalid(root.right, root.val)) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    boolean isSmallerInvalid(TreeNode root, int value) {
        while (root != null) {
            if (root.val >= value) {
                return true;
            }
            root = root.right;
        }
        return false;
    }

    boolean isGreaterInvalid(TreeNode root, int value) {
        while (root != null) {
            if (root.val <= value) {
                return true;
            }
            root = root.left;
        }
        return false;
    }


    // O(n)
    public boolean isValidBST2(TreeNode root) {
        return validate(root, (long) Integer.MIN_VALUE - 1,  (long) Integer.MAX_VALUE + 1);
    }

    boolean validate(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}
