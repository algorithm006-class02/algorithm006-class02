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
  // a. 子问题 dp[i]: 1..i 能偷到 max value: max(dp)
  // b. 状态定义 dp[i]: 表示第 i 个房子必偷的最大值
  // c. DP 方程
  // dp[i] = Max(dp[i - 1], dp[i - 2] + nums[i])

  if (!nums || nums.length === 0) return 0;
  if (nums.length === 1) return nums[0];

  let dp = new Array(nums.length);
  dp[0] = nums[0];
  dp[1] = Math.max(nums[0], nums[1]);
  let res = Math.max(dp[0], dp[1]);
  for (let i = 2; i < nums.length; i++) {
    dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    res = Math.max(res, dp[i]);
  }
  return res;
};
// @lc code=end
