/**
 * 实现Trie(前缀树)
 */

class Trie {
    private Trie[] links;
    private boolean isEnd;
    private final int R = 26;
    /** Initialize your data structure here. */
    public Trie() {
        links = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie tmp = this;
        for(char c : word.toCharArray()) {
            if(tmp.links[c - 'a'] == null)
                tmp.links[c - 'a'] = new Trie();
            tmp = tmp.links[c - 'a'];
        }
        tmp.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie tmp = this;
        for(char c : word.toCharArray()) {
            if(tmp.links[c - 'a'] == null)
                return false;
            tmp = tmp.links[c - 'a'];
        }
        return tmp.isEnd ? true : false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie tmp = this;
        for(char c : prefix.toCharArray()) {
            if(tmp.links[c - 'a'] == null)
                return false;
            tmp = tmp.links[c - 'a'];
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