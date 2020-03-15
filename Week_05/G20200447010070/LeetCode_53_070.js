/*
 * @lc app=leetcode.cn id=53 lang=javascript
 *
 * [53] 最大子序和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
  let sum = 0;
  let max = nums[0];
  for (let num of nums) {
    // 小于等于 0 时，直接舍弃前面的 sum，重新累加
    sum = sum > 0 ? sum + num : num;
    max = Math.max(sum, max);
  }
  return max;
};
// @lc code=end
