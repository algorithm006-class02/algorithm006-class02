/*
 * @lc app=leetcode.cn id=746 lang=javascript
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
  // 状态定义： dp[i] 走第 i 阶楼梯需要花费的力气
  // DP 方程： dp[i] = Min(dp[i - 1], dp[i - 2]) + cost[i]

  let n = cost.length;
  let first = cost[0];
  let second = cost[1];
  for (let i = 2; i < n; i++) {
    [first, second] = [second, Math.min(first, second) + cost[i]];
  }
  return Math.min(first, second);
};
// @lc code=end
