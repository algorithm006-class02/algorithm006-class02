/*
 * @lc app=leetcode.cn id=198 lang=javascript
 *
 * [198] 打家劫舍
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
  // 1. 子问题 dp[i]: 第 i 间偷不偷的 max value
  // 2. 状态定义 dp[i]
  // 3. DP 方程  dp[i] = Max(dp[i-1], dp[i-2] + nums[i])

  if (!nums || nums.length === 0) return 0;
  if (nums.length === 1) return nums[0];
  let dp = new Array(nums.length);
  dp[0] = nums[0];
  dp[1] = Math.max(nums[0], nums[1]);
  let max = Math.max(dp[0], dp[1]);
  for (let i = 2; i < nums.length; i++) {
    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    max = Math.max(max, dp[i]);
  }
  return max;
};
// @lc code=end
