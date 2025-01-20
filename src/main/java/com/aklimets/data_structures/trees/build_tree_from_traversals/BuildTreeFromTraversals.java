package com.aklimets.data_structures.trees.build_tree_from_traversals;

import com.aklimets.data_structures.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromTraversals {

    /*
        You are given two integer arrays preorder and inorder.
        preorder is the preorder traversal of a binary tree
        inorder is the inorder traversal of the same tree
        Both arrays are of the same size and consist of unique values.
        Rebuild the binary tree from the preorder and inorder traversals and return its root.

        Example 1:
        Input: preorder = [1,2,3,4], inorder = [2,1,3,4]
        Output: [1,2,3,null,null,null,4]

        Example 2:
        Input: preorder = [1], inorder = [1]
        Output: [1]

        Constraints:

        1 <= inorder.length <= 1000.
        inorder.length == preorder.length
        -1000 <= preorder[i], inorder[i] <= 1000
    */


    Map<Integer, Integer> inorderIndexes = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexes.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int rootVal = preorder[preStart];
        int inorderRootIndex = inorderIndexes.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        int leftDiff = inorderRootIndex - inStart;
        root.left = dfs(preorder, inorder, preStart + 1, preStart + leftDiff, inStart, inorderRootIndex - 1);

        int rightDiff = inEnd - inorderRootIndex - 1;
        root.right = dfs(preorder, inorder, preEnd - rightDiff, preEnd, inorderRootIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        new BuildTreeFromTraversals().buildTree(new int[] {5,3,1,2,4,6,7}, new int[] {1,2,3,4,5,6,7});
    }
}
