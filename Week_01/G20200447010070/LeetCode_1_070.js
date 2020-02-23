/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  let exists = {};
  for (let i = 0; i < nums.length; i++) {
    let diff = target - nums[i];
    if (typeof exists[diff] !== 'undefined') {
      return [exists[diff], i];
    }
    exists[nums[i]] = i;
  }
};
// @lc code=end
