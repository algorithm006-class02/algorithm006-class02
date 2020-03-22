/**
 * 529. Minesweeper
 * https://leetcode.com/problems/minesweeper/
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 */
/** 方法一：DFS
 * 规则：M => hidden Mine; E => hidden Empty; B => showed Blank; X => showed Mine
 * 点击方块，有两种情况，
      - 如果是 M，将此点变为 X，结束
      - 如果是 E，将相邻（8个方向）的点标记为 1-8 或 B, 递归调用吧所有相邻点都算出来 
      - 某个点的8个相邻点坐标：(row-1, col), (row+1, col), (row, col-1), (row, col+1), (row-1, col-1), (row-1, col+1), (row+1, col-1), (row+1, col+1)
   递归终止条件：数组越界
 
 */
const updateBoard = (board, click) => {
  let [row, col] = [...click]
  if (board[row][col] === 'E') dfs(board, row, col)
  if (board[row][col] === 'M') board[row][col] = 'X'
  return board
};

const dfs = (board, row, col) => {
  let nearlyMineCount = 0
  for (let i = -1; i <= 1; i++) {
    for (let j = -1; j <= 1; j++) {
      let [nearRow, nearCol] = [row+i, col+j]
      if (i === 0 && j === 0) continue
      if (isInvalid(board, nearRow, nearCol)) continue
      if (board[nearRow][nearCol] === 'M' || board[nearRow][nearCol] === 'X') {
        nearlyMineCount++
      }
    }
  }     
  if (nearlyMineCount) {
    board[row][col] = nearlyMineCount.toString()  
    return
  } 
  
  board[row][col] = 'B'
  for (let i = -1; i <= 1; i++) {
    for (let j = -1; j <= 1; j++) {
      let [nearRow, nearCol] = [row+i, col+j]
      if (i === 0 && j === 0) continue
      if (isInvalid(board, nearRow, nearCol)) continue
      if (board[nearRow][nearCol] === 'E') dfs(board, nearRow, nearCol)
    }
  }
}

const isInvalid = (board, row, col) => {
  return row < 0 || row >= board.length || col < 0 || col >= board[0].length
}