/**
 * Trie 树的实现 是前缀树的一种实现，用于检索字符串的数据集的键
 */

class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode(26);

    public TrieNode() {

    }
}

class Trie {
    private TrieNode root;

    public TrieNode() {
        root = new TrieNode();
    }

    /**
     * insert a word into the trie
     *
     * @param word
     */
    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ws.children[ch - 'a'] == null) {
                ws.children[ch - 'a'] = new TrieNode();
            }
            ws = ws.children[ch - 'a'];
        }
        ws.isWord = true;
    }

    public boolean satartsWith(String prefix) {
        return searchHelper(prefix) != null;
    }

    public TrieNode searchHelper(String key) {
        TrieNode ws = root;
        for (int i = 0; i < key.length() && ws != null; i++) {
            char ch = key.charAt(i);
            ws = ws.children[ch - 'a'];
        }
        return ws;
    }
}