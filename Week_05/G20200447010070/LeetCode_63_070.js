/*
 * @lc app=leetcode.cn id=63 lang=javascript
 *
 * [63] 不同路径 II
 */

// @lc code=start
/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
  let width = obstacleGrid[0].length;
  let dp = new Array(width).fill(0);
  dp[0] = 1;
  for (let row of obstacleGrid) {
    for (let i = 0; i < width; i++) {
      if (row[i] === 1) {
        dp[i] = 0;
      } else if (i >= 1) {
        dp[i] += dp[i - 1];
      }
    }
  }
  return dp[width - 1];
};
// @lc code=end
