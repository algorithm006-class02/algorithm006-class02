/**
 * 36. Valid Sudoku
 * https://leetcode-cn.com/problems/valid-sudoku/
 * @param {character[][]} board
 * @return {boolean}
 */
const isValidSudoku = (board) => {
  let [rows, cols, boxes] = [[], [], []]
  for(let i = 0; i < 9; i++) { rows[i] = {}; cols[i] = {}; boxes[i] = {} }

  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[0].length; j++) {
      if (board[i][j] === '.') continue
      let num = parseInt(board[i][j]) 
      let boxIndex = ~~(i / 3) * 3 + ~~(j / 3)
      if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) return false
      rows[i][num] = 1
      cols[j][num] = 1
      boxes[boxIndex][num] = 1
    }
  }
  return true
}