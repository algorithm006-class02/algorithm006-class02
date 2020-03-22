/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function (nums) {
  if (!nums || !nums.length) return 0
  let dp = nums
  for (let i = 1; i < nums.length; i++) {
    dp[i] = Math.max(dp[i - 1], 0) + nums[i]
  }
  return Math.max.apply(this, dp)
};