/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
  if (n <= 2) return n;
  let first = 1;
  let second = 2;
  for (let i = 3; i <= n; i++) {
    [first, second] = [second, first + second];
  }
  return second;
};
// @lc code=end
