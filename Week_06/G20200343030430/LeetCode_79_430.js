/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function (board, word) {
  const m = board.length
  const n = board[0].length
  const visited = {}
  const dir = [{ x: -1, y: 0 }, { x: 1, y: 0 }, { x: 0, y: -1 }, { x: 0, y: 1 }]

  function _dfs (i, j, k) {
    if (k == word.length - 1) return board[i][j] == word[k]
    if (board[i][j] == word[k]) {
      visited[i + '-' + j] = 1
      for (let p = 0; p < 4; p++) {
        let { x, y } = dir[p]
        x += i
        y += j
        let f = x >= 0 && x < m && y >= 0 && y < n
        if (f && !visited[x + '-' + y] && _dfs(x, y, k + 1)) return true
      }
      visited[i + '-' + j] = 0
    }
    return false
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (board[i][j] == word[0] && _dfs(i, j, 0)) return true
    }
  }
  return false
};