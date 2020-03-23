/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function (M) {
  const n = M.length
  const visited = new Array(n).fill(0)
  let sum = 0

  function dfs (i) {
    for (let j = 0; j < n; j++) {
      if (M[i][j] && visited[j] == 0) {
        visited[j] = 1
        dfs(j)
      }
    }
  }

  for (let i = 0; i < n; i++) {
    if (visited[i] == 0) {
      sum++
      dfs(i)
    }
  }
  return sum
};