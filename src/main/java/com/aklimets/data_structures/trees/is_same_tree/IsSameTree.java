package com.aklimets.data_structures.trees.is_same_tree;

import com.aklimets.data_structures.trees.TreeNode;

public class IsSameTree {

    /*
        Given the roots of two binary trees p and q, return true if the trees are equivalent, otherwise return false.
        Two binary trees are considered equivalent if they share the exact same structure and the nodes have the same values.

        Example 1:
        Input: p = [1,2,3], q = [1,2,3]
        Output: true

        Example 2:
        Input: p = [4,7], q = [4,null,7]
        Output: false

        Example 3:
        Input: p = [1,2,3], q = [1,3,2]
        Output: false

        Constraints:

        0 <= The number of nodes in both trees <= 100.
        -100 <= Node.val <= 100
    */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}