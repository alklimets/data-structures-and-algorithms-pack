package com.aklimets.data_structures.tries.imp_word_dictionary;

public class WordDictionary {

    /*
        Design a data structure that supports adding new words and finding if a string matches any previously added string.
        Implement the WordDictionary class:

        WordDictionary() Initializes the object.
        void addWord(word) Adds word to the data structure, it can be matched later.
        bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.


        Example:

        Input
        ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        Output
        [null,null,null,null,false,true,true,true]

        Explanation
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True


        Constraints:

        1 <= word.length <= 25
        word in addWord consists of lowercase English letters.
        word in search consist of '.' or lowercase English letters.
        There will be at most 2 dots in word for search queries.
        At most 104 calls will be made to addWord and search.
    */

    static class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isWord = false;

        public void addWord(String word) {
            TrieNode current = this;
            for (char ch : word.toCharArray()) {
                if (current.nodes[ch - 'a'] == null) {
                    current.nodes[ch - 'a'] = new TrieNode();
                }
                current = current.nodes[ch - 'a'];
            }
            current.isWord = true;
        }

        public boolean search(char[] word, int index) {
            if (word.length == index) {
                return this.isWord;
            }
            boolean result = false;
            char ch = word[index];
            if (ch == '.') {
                for (TrieNode node : this.nodes) {
                    if (node != null) {
                        result |= node.search(word, index + 1);
                        if (result) return true;
                    }
                }
            } else {
                if (nodes[ch - 'a'] != null) {
                    result |= nodes[ch - 'a'].search(word, index + 1);
                }
            }
            return result;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        root.addWord(word);
    }

    public boolean search(String word) {
        return root.search(word.toCharArray(), 0);
    }
}
