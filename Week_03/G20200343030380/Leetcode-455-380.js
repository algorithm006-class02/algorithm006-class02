/**
 * 455. Assign Cookies
 * https://leetcode.com/problems/assign-cookies/
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
// 贪心算法
const findContentChildren = (g, s) => {
  g.sort((a,b)=>a-b)
  s.sort((a,b)=>a-b)
  let len = g.length
  while (s.length) {
    if (s.shift() >= g[0]) g.shift()
  }
  return len - g.length
};