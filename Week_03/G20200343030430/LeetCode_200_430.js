/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
  if (!grid || !grid.length) return 0
  let row = grid.length
  let col = grid[0].length
  let count = 0

  const dfs = (grid, i, j, row, col) => {
    grid[i][j] = '0'
    if (i > 0 && grid[i - 1][j] === '1') {
      dfs(grid, i - 1, j, row, col)
    }
    if (i + 1 < row && grid[i + 1][j] === '1') {
      dfs(grid, i + 1, j, row, col)
    }
    if (j > 0 && grid[i][j - 1] === '1') {
      dfs(grid, i, j - 1, row, col)
    }
    if (j + 1 < col && grid[i][j + 1] === '1') {
      dfs(grid, i, j + 1, row, col)
    }
  }

  for (let i = 0; i < row; i++) {
    for (let j = 0; j < col; j++) {
      if (grid[i][j] === '1') {
        count++
        dfs(grid, i, j, row, col)
      }
    }
  }
  return count
};