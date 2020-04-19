/*
 * @lc app=leetcode.cn id=64 lang=javascript
 *
 * [64] 最小路径和
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
  // 1. 子问题
  // 2. 状态定义
  // 3. DP 方程
  // a[i][j] = Min(a[i-1][j], a[i][j-1]) + nums[i][j];

  let m = grid.length;
  let n = grid[0].length;
  for (let row = 0; row < m; row++) {
    for (let col = 0; col < n; col++) {
      if (row === 0 && col === 0) {
        continue;
      } else if (row === 0) {
        grid[row][col] = grid[row][col - 1] + grid[row][col];
      } else if (col === 0) {
        grid[row][col] = grid[row - 1][col] + grid[row][col];
      } else {
        grid[row][col] =
          Math.min(grid[row - 1][col], grid[row][col - 1]) + grid[row][col];
      }
    }
  }
  return grid[m - 1][n - 1];
};
// @lc code=end
