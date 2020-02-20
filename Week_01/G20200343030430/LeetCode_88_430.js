/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function (nums1, m, nums2, n) {
  let i = m - 1
  let j = n - 1
  let p = m + n - 1
  while (i >= 0 && j >= 0) {
    if (nums1[i] < nums2[j]) {
      nums1[p] = nums2[j]
      p--
      j--
    } else {
      nums1[p] = nums1[i]
      p--
      i--
    }
  }
  if (i == -1) {
    for (let k = 0; k <= j; k++)
      nums1[k] = nums2[k]
  }
};