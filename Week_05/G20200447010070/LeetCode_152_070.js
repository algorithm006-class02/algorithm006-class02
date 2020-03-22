/*
 * @lc app=leetcode.cn id=152 lang=javascript
 *
 * [152] 乘积最大子序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
  // 1. 子问题 max_product(i) = Max(max_product(i-1) * nums[i], nums[i])
  // 2. 状态数组定义 f[i]
  // 3. DP 方程 f[i] = Max(f[i-1] * nums[i], nums[i])
  let min = 1;
  let max = 1;
  let res = -Infinity;
  for (let num of nums) {
    if (num < 0) {
      let tmp = max;
      max = min;
      min = tmp;
    }
    min = Math.min(min * num, num);
    max = Math.max(max * num, num);
    res = Math.max(max, res);
  }
  return res;
};
// @lc code=end
