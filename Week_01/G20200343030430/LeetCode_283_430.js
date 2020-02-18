/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
  let i = 0
  let pos = 0
  while (i < nums.length) {
    let n = nums[i]
    if (n != 0) {
      nums[i] = nums[pos]
      nums[pos] = n
      pos++
    }
    i++
  }
};