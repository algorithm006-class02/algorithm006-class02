/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * @param {character[][]} grid
 * @return {number}
 */
/**
 * 解法一：DFS
 * 思路：假设目前指针指向一个岛屿中的一个点(row, column), 对此点上下左右做深度优先搜索
 * 将此点设为1个岛屿(numIslands + 1), 将搜索到的相邻的为 ‘1’ 的点置为0, 因为他们属于一个岛屿
 * 终止条件：(i, j) 越界； grid[i][j] == 0 代表已到达水界
*/
const numIslands = (grid) => {
  let numIslands = 0
  for (let row = 0; row < grid.length; row++) {
    for (let col = 0; col < grid[0].length; col++) {
      if (grid[row][col] == '1') {
        dfs(grid, row, col)
        numIslands += 1
      }
    }
  }
  return numIslands
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

/**
 * 解法二：BFS
 */
const numIslands = (grid) => {
  if (!grid.length || !grid[0].length) return 0
  let rowLength = grid.length, colLength = grid[0].length, count = 0

  for (let i = 0; i < rowLength; i++) {
    for (let j = 0; j < colLength; j++) {
      if (grid[i][j] === '1') { 
        bfs(rowLength, colLength, grid, i, j)
        count++ 
      }
    }
  }
  return count
}

const bfs = (rowLength, colLength, grid, i, j) => {
  let queue = [i * colLength + j]
  while (queue.length) {
    let idx = queue.shift()
    let [i, j] = [Math.floor(idx / colLength), idx % colLength]
    for (let arr of [[-1, 0], [1, 0], [0, -1], [0, 1]]) {
      let _i = i + arr[0], _j = j + arr[1]
      if (_i >= 0 && _i < rowLength && _j >= 0 && _j < colLength && grid[_i][_j] === '1') {
        queue.push(_i * colLength + _j)
        grid[_i][_j] = '0'
      }
    }
  }
}

/**
 * 解法三：并查集 + 路径压缩
 */
const numIslands = (grid) => {
  if (!grid.length || !grid[0].length) return 0
  let m = grid.length, n = grid[0].length, count = 0, parent = []

  const findParent = (p) => {
    while (p != parent[p]) {
      parent[p] = parent[parent[p]]
      p = parent[p]
    }
    return p
  }

  const union = (p, q) => {
    let rootP = findParent(p), rootQ = findParent(q)
    if (rootP === rootQ) return
    parent[rootP] = rootQ
    count--
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (grid[i][j] === '1') {
        parent[i*n+j] = i * n + j
        count++
      }
    }
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (grid[i][j] === '1') {
        grid[i][j] = '0'
        for (let arr of [[-1, 0], [1, 0], [0, -1], [0, 1]]) {
          let _i = i + arr[0], _j = j + arr[1]
          if (_i >= 0 && _i < m && _j >= 0 && _j < n && grid[_i][_j] === '1') union(i * n + j, _i * n + _j)
        }
      }
    }
  }

  return count
}