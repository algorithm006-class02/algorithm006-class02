/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 * @param {number[][]} grid
 * @return {number}
 */
// recursion O(2^m+n) exceed time limit
const minPathSum = (grid) => {
  return calculate(grid, 0, 0)
}

const calculate = (grid, row, col) => {
  if (row === grid.length || col === grid[0].length) return Number.MAX_SAFE_INTEGER
  if (row === grid.length - 1 && col === grid[0].length - 1) return grid[row][col]
  return grid[row][col] + Math.min(calculate(grid, row + 1, col), calculate(grid, row, col + 1))
}

// DP O(m*n)
const minPathSum = (grid) => {
  let rowLength = grid.length, colLength = grid[0].length
  for (let row = 0; row < rowLength; row++) {
    for (let col = 0; col < colLength; col++) {
      if (row === 0 && col === 0) continue
      else if (row === 0) grid[row][col] += grid[row][col-1]
      else if (col === 0) grid[row][col] += grid[row-1][col]
      else grid[row][col] += Math.min(grid[row-1][col], grid[row][col-1])
    }
  }
  return grid[rowLength-1][colLength-1]
}

/** DP
 * 明确状态：两点间的路径和
 * 确定dp函数定义：dp[row][col] 表示从 [0,0]到[row][col]点的最小路径和为 dp[row][col]
 * 确定选择并择优：无论当前点是哪里，选择就是从该点的左一个点和上一个点选择路径和最小的
 * 明确base case：当该点为[0,0]时，不做任何处理；当点在边缘时，左点和上点只可能存在一个，直接取该值即可；
 * 所以DP方程为：
 *    continue (row === 0, col === 0)
 *    dp[row][col] += dp[row][col-1] (row === 0)
 *    dp[row][col] += dp[row-1][col] (col === 0)
 *    dp[row][col] += Math.min(dp[row-1][col], dp[row][col-1]) 
 */

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */