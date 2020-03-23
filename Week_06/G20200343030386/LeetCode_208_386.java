package com.example.leetCode.Week6;


public class LeetCode_208_386 {
//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例:
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");
//trie.search("app");     // 返回 true
//
// 说明:
//
//
// 你可以假设所有的输入都是由小写字母 a-z 构成的。
// 保证所有输入均为非空字符串。
//
// Related Topics 设计 字典树

    class Trie {
        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            this.root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if (!node.containsKey(curr)) {
                    node.put(curr, new TrieNode());
                }
                node = node.get(curr);
            }
            node.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode trieNode = searchPrefix(word);
            return trieNode != null && trieNode.isEnd();
        }

        public TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if (node.containsKey(curr)) {
                    node = node.get(curr);
                } else {
                    return null;
                }
            }
            return node;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode trieNode = searchPrefix(prefix);
            return trieNode != null;
        }

        class TrieNode {
            private TrieNode[] links;

            private final int R = 26;

            private boolean isEnd;

            public TrieNode() {
                this.links = new TrieNode[R];
            }

            public boolean containsKey(char ch) {
                return links[ch - 'a'] != null;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public void put(char ch, TrieNode node) {
                links[ch - 'a'] = node;
            }

            public void setEnd() {
                this.isEnd = true;
            }

            public boolean isEnd() {
                return this.isEnd;
            }
        }

    }

}
