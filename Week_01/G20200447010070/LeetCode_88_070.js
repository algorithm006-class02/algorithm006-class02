/*
 * @lc app=leetcode.cn id=88 lang=javascript
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  let p1 = m - 1;
  let p2 = n - 1;
  let i = m + n - 1;
  // 只需要注意 nums2 数组是否复制完，nums1 本就是有序的
  while (p2 >= 0) {
    nums1[i--] = nums1[p1] >= nums2[p2] ? nums1[p1--] : nums2[p2--];
  }
};
// @lc code=end
