/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
  const n = s.length
  const dp = []
  for (let i = 0; i < n; i++) {
    dp[i] = new Array(n)
  }
  let str = ''
  for (let i = n - 1; i >= 0; i--) {
    for (let j = i; j < n; j++) {
      dp[i][j] = s[i] == s[j] && (j - i <= 1 || dp[i + 1][j - 1])
      if (dp[i][j] && j + 1 - i > str.length) str = s.substring(i, j + 1)
    }
  }
  return str
};