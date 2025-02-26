package com.aklimets.data_structures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode create(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return null;
        }

        Integer val = queue.poll();
        TreeNode root = new TreeNode(val);

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        create(queue, nodes);
        return root;
    }

    private static void create(Queue<Integer> queue, Queue<TreeNode> nodes) {
        while (!queue.isEmpty() && !nodes.isEmpty()) {
            for (int i = nodes.size(); i > 0; i--) {
                TreeNode poll = nodes.poll();
                if (!queue.isEmpty()) {
                    Integer num = queue.poll();
                    poll.left = new TreeNode(num);
                    nodes.offer(poll.left);
                }

                if (!queue.isEmpty()) {
                    Integer num = queue.poll();
                    poll.right = new TreeNode(num);
                    nodes.offer(poll.right);
                }
            }
        }
    }
}
