/**
 * 212. Word Search II
 * https://leetcode-cn.com/problems/word-search-ii/
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
/**
 * 题解思路：
    题目中已经给出，用字典树来做是效率最高的，所以此题考察的就是字典树的应用。
    分析题目可知，是查询board中的字符上下左右连通匹配到 words 数组中的字符。所以我们对 words 构建字典树，然后遍历board中的每个字符，进行四连通+判断是否匹配字典树} 
 */
const findWords = (board, words) => {
  // base case
  if (!words.length || !board.length || !board[0].length) return []

  // 构造字典树，将words中的元素插入到字典树中
  const trie = new Trie()
  for (let str of words) trie.insert(str)

  // 遍历board列表，对每一个元素进行四联通(前后左右) DFS
  const result = new Set()
  for (let row = 0; row < board.length; row++) {
    for (let col = 0; col < board[0].length; col++) {
      if (trie.root[board[row][col]]) dfs(board, trie.root[board[row][col]], board[row][col], row, col, result)
    }
  }
  return Array.from(result)
}

// 定义DFS
// 针对 board 中的每个字符，以它为起点向上下左右扩散，检查组成的字符是否在字典树中，在字典树中检查用的是DFS
const dfs = (board, node, word, row, col, result) => {
  const dxy = [[-1, 0], [1, 0], [0, -1], [0, 1]]
  if (node.isEnd) result.add(word)
  let temp = board[row][col]
  board[row][col] = '@'
  for (const arr of dxy) {
    let _row = row + arr[0], _col = col + arr[1]
    if (_row >= 0 && _row < board.length && _col >= 0 && _col < board[0].length && node[board[_row][_col]] && board[_row][_col] !== '@') {
      dfs(board, node[board[_row][_col]], word + board[_row][_col], _row, _col, result)
    }
  }
  board[row][col] = temp
}

// 定义字典树(from Leetcode#208)
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
}