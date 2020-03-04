/*
 * @lc app=leetcode.cn id=46 lang=javascript
 *
 * [46] 全排列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
  if (!nums || nums.length === 0) return [[]];
  let output = [];
  void (function backtrack(_nums = nums, pre = []) {
    if (pre.length === nums.length) {
      output.push([...pre]);
      return;
    }
    for (let i = 0; i < _nums.length; i++) {
      pre.push(_nums[i]);
      let arr = _nums.slice(0, i).concat(_nums.slice(i + 1));
      backtrack(arr, pre);
      pre.pop();
    }
  })();
  return output;
};
// @lc code=end
