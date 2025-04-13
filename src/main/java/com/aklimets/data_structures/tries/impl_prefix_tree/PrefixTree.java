package com.aklimets.data_structures.tries.impl_prefix_tree;

import java.util.HashMap;
import java.util.Map;

public class PrefixTree {

    /*
        A prefix tree (also known as a trie) is a tree data structure used to efficiently store and retrieve keys in a set of strings. Some applications of this data structure include auto-complete and spell checker systems.
        Implement the PrefixTree class:

        PrefixTree() Initializes the prefix tree object.
        void insert(String word) Inserts the string word into the prefix tree.
        boolean search(String word) Returns true if the string word is in the prefix tree (i.e., was inserted before), and false otherwise.
        boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
        Example 1:

        Input:
        ["Trie", "insert", "dog", "search", "dog", "search", "do", "startsWith", "do", "insert", "do", "search", "do"]

        Output:
        [null, null, true, false, true, null, true]

        Explanation:
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("dog");
        prefixTree.search("dog");    // return true
        prefixTree.search("do");     // return false
        prefixTree.startsWith("do"); // return true
        prefixTree.insert("do");
        prefixTree.search("do");     // return true
    */

    static class TrieNode {
        Map<Character, TrieNode> nodes = new HashMap<>();
        boolean isWord = false;
    }

    TrieNode head;

    public PrefixTree() {
        head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = head;
        for (char ch : word.toCharArray()) {
            if (!current.nodes.containsKey(ch)) {
                TrieNode node = new TrieNode();
                current.nodes.put(ch, node);
            }
            current = current.nodes.get(ch);
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = head;
        for (char ch : word.toCharArray()) {
            if (!current.nodes.containsKey(ch)) {
                return false;
            }
            current = current.nodes.get(ch);
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = head;
        for (char ch : prefix.toCharArray()) {
            if (!current.nodes.containsKey(ch)) {
                return false;
            }
            current = current.nodes.get(ch);
        }
        return true;
    }

}
