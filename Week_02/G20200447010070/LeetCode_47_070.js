/*
 * @lc app=leetcode.cn id=47 lang=javascript
 *
 * [47] 全排列 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
  if (!nums || nums.length === 0) return [[]];
  let output = [];
  // 先排序方便后面剪枝
  nums.sort();
  void (function backtrack(_nums = nums, stack = []) {
    if (stack.length === nums.length) {
      output.push([...stack]);
      return;
    }
    for (let i = 0; i < _nums.length; i++) {
      if (i > 0 && _nums[i] === _nums[i - 1]) continue;
      stack.push(_nums[i]);
      let arr = _nums.slice(0, i).concat(_nums.slice(i + 1));
      backtrack(arr, stack);
      stack.pop();
    }
  })();
  return output;
};
// @lc code=end
