/*
 * @lc app=leetcode.cn id=283 lang=javascript
 *
 * [283] 移动零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
  if (!nums || nums.length === 0) return;

  let lastNonZeroAt = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] != 0) {
      nums[lastNonZeroAt] = nums[i];
      if (i != lastNonZeroAt) {
        nums[i] = 0;
      }
      lastNonZeroAt++;
    }
  }
};
// @lc code=end
