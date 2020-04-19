package week6;

/**
 * 208. 实现 TrieNode (前缀树)
 * 实现一个 TrieNode (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 说明:
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!curr.containsKey(letter)) {
                curr.put(letter, new TrieNode());
            }
            curr = curr.get(letter);
        }
        curr.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = searchPrefix(word);
        return curr != null && curr.isEnd;
    }

    private TrieNode searchPrefix(String target) {
        TrieNode curr = root;
        for (int i = 0; i < target.length(); i++) {
            char letter = target.charAt(i);
            if (curr.containsKey(letter)) {
                curr = curr.get(letter);
            } else {
                return null;
            }
        }
        return curr;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    /**
     * 作为字典树的节点
     * 每个节点都有N个叉
     */
    private static class TrieNode {
        private static final int R = 26;
        private TrieNode[] nodes;
        private boolean isEnd;

        public TrieNode() {
            nodes = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return nodes[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return nodes[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            nodes[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
