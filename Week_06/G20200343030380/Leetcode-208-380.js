/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
/**
 * 使用传统 function函数
 */
var Trie = function() {
  this.root = {}
}

Trie.prototype.insert = function(word) {
  let node = this.root
  for (let i = 0; i < word.length; i++) {
    if (!node[word[i]]) node[word[i]] = {}
    node = node[word[i]]
  }
  node.isEnd = true
}

Trie.prototype.search = function(word) {
  let node = this.searchNode(word)
  if (!node) return false
  return node.isEnd === true
};

Trie.prototype.startsWith = function(prefix) {
  let node = this.searchNode(prefix)
  return node != null
};

Trie.prototype.searchNode = function(word) {
  let node = this.root
  for (let i = 0; i < word.length; i++) {
    if (!node[word[i]]) return
    node = node[word[i]]
  }
  return node
}

/**
 * 使用ES6 class (推荐)
 */
class Trie {
  constructor (){
    this.root = {}
    this.isEnd = false
  }

  insert(word) {
    let node = this.root
    for (let i = 0; i < word.length; i++) {
      if (!node[word[i]]) node[word[i]] = {}
      node = node[word[i]]
    }
    node.isEnd = true
  }

  search(word) {
    let node = this.__search(word)
    return Boolean(node && node.isEnd)
  }

  startsWith(prefix) {
    let node = this.__search(prefix)  
    return Boolean(node)
  }

  __search(word) {
    let node = this.root
    for (let i = 0; i < word.length; i++) {
      if (!node[word[i]]) return 
      node = node[word[i]]
    }
    return node
  }
}
/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */