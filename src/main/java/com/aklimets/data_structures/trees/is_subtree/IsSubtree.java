package com.aklimets.data_structures.trees.is_subtree;

import com.aklimets.data_structures.trees.TreeNode;

public class IsSubtree {

    /*
        Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
        A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

        Example 1:
        Input: root = [1,2,3,4,5], subRoot = [2,4,5]
        Output: true

        Example 2:
        Input: root = [1,2,3,4,5,null,null,6], subRoot = [2,4,5]
        Output: false

        Constraints:

        0 <= The number of nodes in both trees <= 100.
        -100 <= root.val, subRoot.val <= 100
    */

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if(isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
