/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
// 方法一：使用 Array splice、push、sort methods
var merge = function(nums1, m, nums2, n) {
  nums1.splice(m)
  nums2.splice(n)
  nums1.push(...nums2)
  nums1.sort((a, b) => a - b)
};