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
  let memo = new Array(n + 1).fill(-1);
  return helper(n, memo);
};
function helper(n, memo) {
  if (n < 3) return n;
  if (memo[n] === -1) memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
  return memo[n];
}
// @lc code=end
