/*
 * @lc app=leetcode.cn id=77 lang=javascript
 *
 * [77] 组合
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
  if (n <= 0 || k <= 0 || n < k) return [[]];
  let output = [];
  void (function backtrack(begin = 1, pre = []) {
    if (pre.length === k) {
      output.push([...pre]);
      return;
    }
    for (let i = begin; i <= n - (k - pre.length) + 1; i++) {
      pre.push(i);
      backtrack(i + 1, pre);
      pre.pop();
    }
  })();
  return output;
};
// @lc code=end
