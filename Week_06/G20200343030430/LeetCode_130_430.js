/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve = function (board) {
  if (!board || !board[0] || !board[0].length) return
  const m = board.length
  const n = board[0].length

  function dfs (i, j) {
    if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#' || board[i][j] == 'X') return
    board[i][j] = '#'
    dfs(i - 1, j)
    dfs(i + 1, j)
    dfs(i, j - 1)
    dfs(i, j + 1)
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
        dfs(i, j)
      }
    }
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (board[i][j] == 'O') {
        board[i][j] = 'X'
      } else if (board[i][j] == '#') {
        board[i][j] = 'O'
      }
    }
  }
};