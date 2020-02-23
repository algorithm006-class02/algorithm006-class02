/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// 方法一：通过下标替换元素
const moveZeroes = (nums) => {
  let zeroes_count = 0
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] != 0) {
      nums[i-zeroes_count] = nums[i]
      if (zeroes_count > 0) { nums[i] = 0 }
    } else {
      zeroes_count++
    } 
  }
}