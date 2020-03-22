/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
  if (!grid.length || !grid[0].length) return 0
  let m = grid.length
  let n = grid[0].length
  for (let i = m - 1; i >= 0; i--) {
    for (let j = n - 1; j >= 0; j--) {
      if (i == m - 1 && j != n - 1) {
        grid[i][j] = grid[i][j] + grid[i][j + 1]
      } else if (i != m - 1 && j == n - 1) {
        grid[i][j] = grid[i][j] + grid[i + 1][j]
      } else if (i != m - 1 && j != n - 1) {
        grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1])
      }
    }
  }
  return grid[0][0]
};
