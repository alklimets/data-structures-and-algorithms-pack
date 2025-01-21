package com.aklimets.data_structures.trees.serialize_tree;

import com.aklimets.data_structures.trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeTree {

    /*
        Implement an algorithm to serialize and deserialize a binary tree.
        Serialization is the process of converting an in-memory structure into a sequence of bits so that it can be stored or sent across a network to be reconstructed later in another computer environment.
        You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure. There is no additional restriction on how your serialization/deserialization algorithm should work.
        Note: The input/output format in the examples is the same as how NeetCode serializes a binary tree. You do not necessarily need to follow this format.

        Example 1:
        Input: root = [1,2,3,null,null,4,5]
        Output: [1,2,3,null,null,4,5]

        Example 2:
        Input: root = []
        Output: []

        Constraints:

        0 <= The number of nodes in the tree <= 1000.
        -1000 <= Node.val <= 1000
    */

    static class Helper {
        List<String> items;

        Helper(List<String> items) {
            this.items = items;
        }

        int index = 0;

        boolean isEmpty() {
            return items.size() <= index;
        }

        String next() {
            return items.get(index++);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> items = new ArrayList<>();
        dfs(root, items);
        return String.join(",", items);
    }

    private void dfs(TreeNode root, List<String> items) {
        if (root == null) {
            items.add("null");
            return;
        }
        items.add(String.valueOf(root.val));
        dfs(root.left, items);
        dfs(root.right, items);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> items = Arrays.asList(data.split(","));
        return construct(new Helper(items));
    }

    private TreeNode construct(Helper helper) {
        if (helper.isEmpty()) {
            return null;
        }
        String next = helper.next();
        if (next.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode();
        node.val = Integer.parseInt(next);
        node.left = construct(helper);
        node.right = construct(helper);
        return node;
    }
}
