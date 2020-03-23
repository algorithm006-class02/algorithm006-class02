/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function (board, words) {
  class Trie {
    root = new TrieNode()

    insert (word) {
      let p = this.root
      for (let c of word) {
        let index = c.charCodeAt() - 97
        if (!p.children[index]) {
          p.children[index] = new TrieNode()
        }
        p = p.children[index]
      }
      p.str = word
      p.end = true
    }

    search (word) {
      let p = this.root
      for (let c of word) {
        let index = c.charCodeAt() - 97
        if (!p.children[index]) return false
        p = p.children[index]
      }
      return p.end
    }

    startsWith (prefix) {
      let p = this.root
      for (let c of prefix) {
        let index = c.charCodeAt() - 97
        if (!p.children[index]) return false
        p = p.children[index]
      }
      return true
    }
  };

  class TrieNode {
    str = ''
    end = false
    children = new Array(26)
  }

  function dfs (i, j, cur) {
    if (i < 0 || j < 0 || i >= m || j >= n || visited[i + '-' + j]) return
    cur = cur.children[board[i][j].charCodeAt() - 97]
    if (!cur) return

    visited[i + '-' + j] = 1
    if (cur.end) {
      res.add(cur.str)
      // return
    }
    dfs(i - 1, j, cur)
    dfs(i + 1, j, cur)
    dfs(i, j - 1, cur)
    dfs(i, j + 1, cur)
    visited[i + '-' + j] = 0
  }

  const m = board.length
  const n = board[0].length
  const res = new Set()
  const visited = {} // new Array(m).fill(new Array(n).fill(0))
  const trie = new Trie()
  for (let w of words) {
    trie.insert(w)
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      dfs(i, j, trie.root)
    }
  }
  return Array.from(res)
};