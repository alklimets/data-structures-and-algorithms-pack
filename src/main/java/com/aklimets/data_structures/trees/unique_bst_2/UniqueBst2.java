package com.aklimets.data_structures.trees.unique_bst_2;

import com.aklimets.data_structures.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBst2 {

    /*
        Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes
        of unique values from 1 to n. Return the answer in any order.

        Example 1:
        Input: n = 3
        Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

        Example 2:
        Input: n = 1
        Output: [[1]]

        Constraints:

        1 <= n <= 8
    */

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();

        if (start > end) {
            List<TreeNode> a = new ArrayList<>();
            a.add(null);
            return a;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }

        return trees;
    }

}
