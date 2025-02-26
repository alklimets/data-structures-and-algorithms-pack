package com.aklimets.data_structures.trees.max_width_of_tree;

import com.aklimets.data_structures.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfTree {

    /*
        Given the root of a binary tree, return the maximum width of the given tree.
        The maximum width of a tree is the maximum width among all levels.
        The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
        It is guaranteed that the answer will in the range of a 32-bit signed integer.

        Example 1:
        Input: root = [1,3,2,5,3,null,9]
        Output: 4
        Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

        Example 2:
        Input: root = [1,3,2,5,null,null,9,6,null,7]
        Output: 7
        Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).

        Example 3:
        Input: root = [1,3,2,5]
        Output: 2
        Explanation: The maximum width exists in the second level with length 2 (3,2).

        Constraints:

        The number of nodes in the tree is in the range [1, 3000].
        -100 <= Node.val <= 100
    */

    static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int max = 1;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while(!queue.isEmpty()) {
            int start = -1;
            int end = -1;
            for (int i = queue.size(); i > 0; i--) {
                Pair<TreeNode, Integer> poll = queue.poll();
                TreeNode node = poll.getKey();
                int index = poll.getValue();
                if (start == -1) start = index;
                end = index;

                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * index));
                }

                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * index + 1));
                }
            }
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
