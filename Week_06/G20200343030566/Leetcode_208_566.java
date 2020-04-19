package com.sebar.test.leetcode.six.practice;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description
 * 208. 实现 Trie (前缀树) 字典树
 */
public class Leetcode_208_566 {
    class Trie {
        private final int ALPHABET_SIZE = 26;
        private Trie[] children = new Trie[ALPHABET_SIZE];
        private boolean isEndOfWord = false;

        /**
         * Initialize your data structure here
         */
        public Trie() {
        }

        /**
         * insert a word into the trie
         */
        public void insert(String word) {
            Trie temp = this;
            for (char i : word.toCharArray()) {
                if (temp.children[i - 'a'] == null) {
                    temp.children[i - 'a'] = new Trie();
                }
                temp = temp.children[i - 'a'];
            }
            temp.isEndOfWord = true;
        }

        /**
         * Returns if the word is in the trie
         */
        public boolean search(String word) {
            Trie temp = this;
            for (char i : word.toCharArray()) {
                if (temp.children[i - 'a'] == null) {
                    return false;
                }
                temp = temp.children[i - 'a'];
            }
            return temp.isEndOfWord ? true : false;
        }

        /**
         * Return if there is any word in the trie that starts with the given prefix
         */
        public boolean startsWith(String prefix) {
            Trie temp = this;
            for (char i : prefix.toCharArray()) {
                if (temp.children[i - 'a'] == null) {
                    return false;
                }
                temp = temp.children[i - 'a'];
            }
            return true;
        }


    }
}
