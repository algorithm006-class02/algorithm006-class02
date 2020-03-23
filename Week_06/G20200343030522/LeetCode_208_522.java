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


import sun.tools.jconsole.inspector.XNodeInfo;

//leetcode submit region begin(Prohibit modification and deletion)
class TrieNode {
    private final static int R = 26;
    private final TrieNode[] links;
    private boolean end;

    public TrieNode() {
        this.links = new TrieNode[R];
    }

    public boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd() {
        this.end = true;
    }
}

class Trie {

    private final TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char ch : chars) {
            if (!node.contains(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char ch : chars) {
            if (!node.contains(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (char ch : chars) {
            if (!node.contains(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
