/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function (obstacleGrid) {
  let m = obstacleGrid.length
  if (m < 1) return 0
  let n = obstacleGrid[0].length
  if (n < 1) return 0
  if (obstacleGrid[0][0] || obstacleGrid[m - 1][n - 1]) return 0
  // 可达值
  obstacleGrid[0][0] = 1
  // 设置首行首列可达值
  for (let i = 1; i < n; i++) {
    // 上一个可达 && 自己非障碍
    obstacleGrid[0][i] = (obstacleGrid[0][i - 1] == 1 && obstacleGrid[0][i] == 0) ? 1 : 0
  }
  for (let i = 1; i < m; i++) {
    obstacleGrid[i][0] = (obstacleGrid[i - 1][0] == 1 && obstacleGrid[i][0] == 0) ? 1 : 0
  }
  for (let i = 1; i < m; i++) {
    for (let j = 1; j < n; j++) {
      if (obstacleGrid[i][j] == 0) {
        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]
      } else {
        // 障碍，可达值设置为0
        obstacleGrid[i][j] = 0
      }
    }
  }
  return obstacleGrid[m - 1][n - 1]
};