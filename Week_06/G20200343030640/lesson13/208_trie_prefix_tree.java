package "lesson13";
import java.util.*;

/**
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 */


class Trie {

    /** Initialize your data structure here. */
    private final int ALPHATABLESIZE=26;
    private boolean isEnd = false;
    private Trie[] links = new Trie[ALPHATABLESIZE];

    public Trie() {
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;

        for (int i=0; i< word.length();i++){
            char currentChar = word.charAt(i);
            if(node.links[currentChar-'a'] == null){
                node.links[currentChar-'a'] = new Trie();
            }
            node = node.links[currentChar-'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for(char i: word.toCharArray()){
            if(node.links[i-'a'] == null){
                return false;
            }
            node = node.links[i-'a'];
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for(char i: prefix.toCharArray()){
            if(node.links[i-'a'] == null){
                return false;
            }
            node = node.links[i-'a'];
        }
        return node != null? true: false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */