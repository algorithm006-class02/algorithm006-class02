/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function (m, n) {
  let arr = new Array(n).fill(1)
  for (let i = 1; i < m; i++) {
    for (let j = 1; j < n; j++) {
      arr[j] += arr[j - 1]
    }
  }
  return arr[n - 1]
};