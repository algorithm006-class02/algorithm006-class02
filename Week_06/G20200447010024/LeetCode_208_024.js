/*
 * @lc app=leetcode.cn id=208 lang=javascript
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (63.24%)
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
/**
 * Initialize your data structure here.
 */
var Trie = function() {
    this.node = {}
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    const arrs = word.split('')
    let node = this.node

    for (let i = 0; i < arrs.length; i++) {
        const w = arrs[i]
        if (!node[w]) {
            node[w] = {}
        }
        node = node[w]
    }

    node.isEnd = true
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    const arrs = word.split('')
    let node = this.node
    
    for (let i = 0; i < arrs.length; i++) {
        if (!node[arrs[i]]) {
            return false
        }
        node = node[arrs[i]]
    }

    return !!node.isEnd
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    const arrs = prefix.split('')
    let node = this.node

    for (let i = 0; i < arrs.length; i++) {
        if (!node[arrs[i]]) {
            return false
        }
        node = node[arrs[i]]
    }

    return true
};

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
// @lc code=end

