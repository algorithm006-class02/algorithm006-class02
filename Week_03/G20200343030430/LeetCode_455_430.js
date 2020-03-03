/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function (g, s) {
  let i = 0
  let j = 0
  let res = 0
  g.sort((a, b) => a - b)
  s.sort((a, b) => a - b)
  while (i < g.length && j < s.length) {
    if (g[i] <= s[j]) {
      res++
      i++
    }
    j++
  }
  return res
};