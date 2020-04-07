/*
 * @lc app=leetcode.cn id=72 lang=javascript
 *
 * [72] 编辑距离
 */

// @lc code=start
/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
  // 1. 子问题 dp[i][j]: word1 到 i 位置转换成 word2 到 j 位置需要的最少步数
  // 2. 状态定义 dp[i][j]
  // 3. DP 方程
  // dp[i][j] = if word1[i] === word2[j]: dp[i-1][j-1]
  // dp[i][j] = if word1[i] !== word2[j]:
  //                Min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])

  if (word1.length === 0) return word2.length;
  if (word2.length === 0) return word1.length;

  let m = word1.length;
  let n = word2.length;
  let dp = new Array(m + 1).fill(0).map(() => new Array(n + 1).fill(0));
  for (let i = 0; i <= m; i++) {
    dp[i][0] = i;
  }
  for (let j = 0; j <= n; j++) {
    dp[0][j] = j;
  }
  for (let i = 1; i <= m; i++) {
    for (let j = 1; j <= n; j++) {
      if (word1[i - 1] === word2[j - 1]) {
        dp[i][j] = dp[i - 1][j - 1];
      } else {
        dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
      }
    }
  }
  return dp[m][n];
};
// @lc code=end
