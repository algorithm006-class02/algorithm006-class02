package week06;

import week06.entity.TrieNode;

/**
 * 实现 Trie (前缀树)
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 */
public class LeetCode_208_564 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));

    }
}

class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie.
     * 时间复杂度：O(m)，其中 m 为键长。在算法的每次迭代中，我们要么检查要么创建一个
     * 节点，直到到达键尾。只需要 m 次操作。
     *
     * 空间复杂度：O(m)。最坏的情况下，新插入的键和 Trie 树中已有的键没有公共前缀。
     * 此时需要添加 m 个结点，使用 O(m)空间。
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char w : word.toCharArray()) {
            if (!node.containsKey(w)) {
                node.put(w, new TrieNode());
            }
            node = node.get(w);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie.
     *  时间复杂度：O(m) 最坏情况需要 m 次，因为键长是m
     *  空间复杂度：O(1)
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char w : word.toCharArray()) {
            if (node.containsKey(w)) {
                node = node.get(w);
            }else {
                return null;
            }
        }
        return node;
    }

    /** Returns if there is any word in the trie that starts with the given prefix.
     *  时间复杂度：O(m) 最坏情况需要 m 次，因为键长是m
     *  空间复杂度：O(1)
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */