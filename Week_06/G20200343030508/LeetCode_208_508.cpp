/*
 * @lc app=leetcode.cn id=208 lang=cpp
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (64.35%)
 * Likes:    225
 * Dislikes: 0
 * Total Accepted:    28K
 * Total Submissions: 42.7K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
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
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start
class Trie {
private:
    bool isEnd;
    Trie *node[26];
public:
    /** Initialize your data structure here. */
    Trie() {
        isEnd = false;
        for( int i = 0; i < 26; i++) {
            node[i] = NULL;
        }
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie * t = this;
        for (char c : word) {
            if(t->node[c - 'a'] == NULL) {
                 t->node[c - 'a'] = new Trie();               
            }
            t = t->node[c - 'a'];
        }
        t->isEnd = true;
        
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        Trie * t = this;
        for (char c : word) {
            if(t->node[c - 'a'] == NULL) {
                 return false;              
            }
           t = t->node[c - 'a'];
        }
        return t->isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie *t = this;
        for(char w : prefix) {
            if(t != NULL) {
                t = t->node[w - 'a'];
            }else{
                break;
            }
        }
        return t != NULL;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
// @lc code=end

