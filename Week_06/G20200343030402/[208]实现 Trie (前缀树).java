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


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private Trie[] tries;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        this.tries = new Trie[26];
        this.isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {

        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (trie.tries[idx] == null) {
                trie.tries[idx] = new Trie();
            }
            trie = trie.tries[idx];
        }
        trie.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (trie.tries[idx] == null) {
                return false;
            }
            trie = trie.tries[idx];
        }

        return trie.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = this;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (trie.tries[idx] == null) {
                return false;
            }
            trie = trie.tries[idx];
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
