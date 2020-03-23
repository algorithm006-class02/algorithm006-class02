/*
 * @lc app=leetcode.cn id=208 lang=cpp
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {
private:
	bool is_string = false;
	Trie* next[26] = { nullptr };
    /** Initialize your data structure here. */
public:
	Trie() {}
    
    /** Inserts a word into the trie. */
    void insert(string word) {
		Trie* root = this;
		for (const auto& w : word) {
			if (root->next[w - 'a'] == nullptr)root->next[w - 'a'] = new Trie();
			root = root->next[w - 'a'];
		}
		root->is_string = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
		Trie* root = this;
		for (const auto& w : word) {
			if (root->next[w - 'a'] == nullptr) return false;
			root = root->next[w - 'a'];
		}
		return root->is_string;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
		Trie* root = this;
		for (const auto& p : prefix) {
			if (root->next[p - 'a'] == nullptr) return false;
			root = root->next[p - 'a'];
		}
		return true;
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

