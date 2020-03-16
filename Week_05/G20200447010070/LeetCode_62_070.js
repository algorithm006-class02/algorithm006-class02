/*
 * @lc app=leetcode.cn id=62 lang=javascript
 *
 * [62] 不同路径
 */

// @lc code=start
/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
  let dp = new Array(m).fill(1);
  for (let i = 1; i < n; i++) {
    for (let j = 1; j < m; j++) {
      dp[j] += dp[j - 1];
    }
  }
  return dp[m - 1];
};
// @lc code=end
