/**
 * 130. Surrounded Regions
 * https://leetcode-cn.com/problems/surrounded-regions/
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
/**
 * DFS 
 * 题目已知，只有边缘的O或者与边缘相连的O不会被置换为X，其他的O直接换为X即可
 * 所以遍历矩阵，从边缘开始，遇到 O 就启动 DFS，找到四连通的所有 O 元素，临时置换为 #
 * 再次遍历矩阵，将所有的O换为X，将所有的#换为O 即可
 */
const solve = (board) => {
  if (!board.length || !board[0].length) return []
  const m = board.length, n = board[0].length

  const dfs = (i, j) => {
    if (i < 0 || i >= m || j < 0 || j >= n) return
    if (board[i][j] === 'X' || board[i][j] === '#') return

    board[i][j] = '#'
    for (let arr of [[-1, 0], [1, 0], [0, -1], [0, 1]]) dfs(i+arr[0], j+arr[1])
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      let isEdge = (i === 0 || i === m-1 || j === 0 || j === n-1)
      if(isEdge && board[i][j] === 'O') dfs(i, j)
    }
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (board[i][j] === 'O') board[i][j] = 'X'
      if (board[i][j] === '#') board[i][j] = 'O'
    }
  }

  return board
}