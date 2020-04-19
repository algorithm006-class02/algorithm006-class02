/**
 * 51. N-Queens
 * https://leetcode-cn.com/problems/n-queens/
 * @param {number} n
 * @return {string[][]}
 */
/**
 * 方法一：DFS + 对角线约束: 同一对角线上的两个坐标，横坐标之差等于纵坐标之差
 */
const solveNQueens = (n) => {
  const result = []
  dfs(result, n)
  return result
}

const dfs = (result, n, cols = [], row = 0) => {
  if (row === n) return result.push(cols.map(col => ".".repeat(col) + "Q" + ".".repeat(n - col - 1)))
  for (let col = 0; col < n; ++col) {
    if (cols.some((_col, _row) => _col === col || Math.abs(_col - col) === Math.abs(row - _row))) continue
    cols.push(col)
    dfs(result, n, cols, row+1)
    cols.pop()
  }
}

/**
 * 方法二：DFS + 对角线约束优化版
const solveNQueens = (n) => {
  let result = [];
  const dfs(cols) {
    let row = cols.length
    if (row === n) return result.push(cols.map(col => '.'.repeat(col) + 'Q' + '.'.repeat(n - col -1)))
    for (let col = 0; col < n; col++) {
      if(cols.some((_col, _row) => (_col === col || Math.abs(_col - col) === Math.abs(row - _row))) continue
      dfs(cols.concat(col))
    }
  }
  dfs([])
  return result
}
*/

/**
 * 方法三：位运算 (与 N-QueensII 题目一致)
 */