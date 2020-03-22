/**
 * Initialize your data structure here.
 */
var Trie = function () {
  this.root = {
    char: '/',
    end: false,
    children: new Array(26)
  }
};

/**
 * Inserts a word into the trie.
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function (word) {
  let p = this.root
  for (let c of word) {
    let index = c.charCodeAt() - 97
    if (!p.children[index]) {
      p.children[index] = { char: c, end: false, children: new Array(26) }
    }
    p = p.children[index]
  }
  p.end = true
};

/**
 * Returns if the word is in the trie.
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function (word) {
  let p = this.root
  for (let c of word) {
    let index = c.charCodeAt() - 97
    if (!p.children[index]) return false
    p = p.children[index]
  }
  return p.end
};

/**
 * Returns if there is any word in the trie that starts with the given prefix.
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function (prefix) {
  let p = this.root
  for (let c of prefix) {
    let index = c.charCodeAt() - 97
    if (!p.children[index]) return false
    p = p.children[index]
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