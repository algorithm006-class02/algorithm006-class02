/**
 * 77. Combinations
 * https://leetcode.com/problems/combinations/
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
const combine = (n, k) => {
  let result = []  
  const dfs = (current, start) => {
    if (current.length == k) {
      result.push(current)
      return
    }
    for (let i = start; i <= n; i++) {
      dfs([...current, i], i+1)
    }
  }
  dfs([], 1)
  return result
};