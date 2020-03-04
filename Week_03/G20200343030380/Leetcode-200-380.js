/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * @param {character[][]} grid
 * @return {number}
 */
// 方法一：DFS
// 思路：假设目前指针指向一个岛屿中的一个点(row, column), 对此点上下左右做深度优先搜索
// 将此点设为1个岛屿(numIslands + 1), 将搜索到的相邻的为 ‘1’ 的点置为0, 因为他们属于一个岛屿
// 终止条件：(i, j) 越界； grid[i][j] == 0 代表已到达水界
const numIslands = (grid) => {
  let nums = 0
  for (let row = 0; row < grid.length; row++) {
    for (let col = 0; col < grid[0].length; col++) {
      if (grid[row][col] == '1') {
        dfs(grid, row, col)
        nums += 1
      }
    }
  }
  return nums 
};

const dfs = (grid, row, col) => {
  if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return
  if (grid[row][col] == '0') return
  grid[row][col] = '0'
  dfs(grid, row-1, col)
  dfs(grid, row+1, col)
  dfs(grid, row, col-1)
  dfs(grid, row, col+1)
}

// 方法二：BFS