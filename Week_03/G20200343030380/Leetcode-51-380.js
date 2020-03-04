/**
 * 51. N-Queens
 * https://leetcode.com/problems/n-queens/
 * @param {number} n
 * @return {string[][]}
 */
// 方法一：回溯
const solveNQueens = (n) => {
  let result = []
  backtrack(result, n)
  return result
};

const backtrack = (result, n, board = [], row = 0) => {
  if (row === n) {
    generateChessBoard(result, board, n)
    return
  }
  for (let col = 0; col < n; col++) {
    if (isValid(board, n, row, col)) {
      board.push(col)
      backtrack(result, n, board, row+1)
      board.pop()
    }
  }
}

const isValid = (board, n, row, col) => {
  for (let r = 0; r < row; r++) {
    const c = board[r]
    if (col === c) return false
    const colDistance = Math.abs(col - c)
    const rowDistance = row - r
    if (colDistance === rowDistance) return false
  }  
  return true
}

const generateChessBoard = (result, board, n) => {
  const boardWithQueens = board.map(col => ".".repeat(col) + "Q" + ".".repeat(n -col-1))
  result.push(boardWithQueens)
}

solveNQueens(8)