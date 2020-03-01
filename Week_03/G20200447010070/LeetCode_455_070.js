/*
 * @lc app=leetcode.cn id=455 lang=javascript
 *
 * [455] 分发饼干
 */

// @lc code=start
/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
  if (!g || !s || s.length === 0) return 0;

  g.sort((a, b) => a - b);
  s.sort((a, b) => a - b);

  let gi = 0;
  let sj = 0;
  let res = 0;

  while (gi < g.length && sj < s.length) {
    if (g[gi] <= s[sj]) {
      gi++;
      sj++;
      res++;
    } else {
      sj++;
    }
  }
  return res;
};
// @lc code=end
