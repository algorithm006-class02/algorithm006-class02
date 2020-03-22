/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function (triangle) {
  if (!triangle || !triangle.length || !triangle[0].length) return 0
  let dp = triangle
  for (let i = triangle.length - 2; i >= 0; i--) {
    for (let j = 0; j < triangle[i].length; j++) {
      dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j + 1])
    }
  }
  return dp[0][0]
};