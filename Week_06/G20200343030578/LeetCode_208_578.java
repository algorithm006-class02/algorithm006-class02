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

// 字典树节点 TrieNode
// 每个节点属性包括
    // 1. 一个含有 26 个节点的数组（如下面的 link ）
    // 2. 是否是叶子节点（终端节点，表示已经构成单词）
// 方法包括
// 1. containsKey( char )：该节点是否包含给定字母
// 2. get( char )：获取给定字母的下一个节点
// 3. put( char, TrieNode )：为当前节点添加 key 为给定字母的下一个节点
// 4. setEnd()：设置终端节点标记
// 5. isEnd()：判断是否是终端节点
class TrieNode {
    private int R = 26;
    private TrieNode[] link;
    private boolean isEnd = false;

    public TrieNode() {
        link = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return link[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return link[ch - 'a'];
    }

    public void put(char ch, TrieNode node){
        link[ch - 'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}

// 字典树 Trie
class Trie {

    private TrieNode root;

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
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);

            if(! node.containsKey(curLetter))
                node.put(curLetter, new TrieNode());

            node = node.get(curLetter);
        }

        node.setEnd();
    }
    // 与 insert 相对
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);

            if(node.containsKey(curLetter))
                node = node.get(curLetter);
            else
                return null;
        }

        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);

        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
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
