package com.aklimets.data_structures.trees.max_path_sum;

import com.aklimets.data_structures.trees.TreeNode;

public class MaxPathSum {

    /*
        Given the root of a non-empty binary tree, return the maximum path sum of any non-empty path.
        A path in a binary tree is a sequence of nodes where each pair of adjacent nodes has an edge connecting them. A node can not appear in the sequence more than once. The path does not necessarily need to include the root.
        The path sum of a path is the sum of the node's values in the path.

        Example 1:
        Input: root = [1,2,3]
        Output: 6
        Explanation: The path is 2 -> 1 -> 3 with a sum of 2 + 1 + 3 = 6.

        Example 2:
        Input: root = [-15,10,20,null,null,15,5,-5]
        Output: 40
        Explanation: The path is 15 -> 20 -> 5 with a sum of 15 + 20 + 5 = 40.

        Constraints:

        1 <= The number of nodes in the tree <= 1000.
        -1000 <= Node.val <= 1000

    */

    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxValue;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        int fullSum = root.val + left + right;
        int leftSum = root.val + left;
        int rightSum = root.val + right;
        int pathMax = Math.max(Math.max(root.val, fullSum), Math.max(leftSum, rightSum));
        int returnMax = Math.max(root.val, Math.max(leftSum, rightSum));
        maxValue = Math.max(maxValue, pathMax);
        return Math.max(returnMax, 0);
    }
}