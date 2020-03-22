/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function (text1, text2) {
  if (!text1 || !text2 || !text1.length || !text2.length) return 0
  let m = text1.length
  let n = text2.length
  let dp = []
  for (let i = 0; i <= m; i++) {
    dp.push(new Array(n + 1).fill(0))
  }
  for (let i = 1; i <= m; i++) {
    for (let j = 1; j <= n; j++) {
      if (text1[i - 1] == text2[j - 1]) {
        dp[i][j] = dp[i - 1][j - 1] + 1
      } else {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
      }
    }
  }
  return dp[m][n]
};