/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */

// 方法一: 使用 unshift、splice 方法 O(n^2)
// const rotate = (nums, k) => {
//   nums.unshift(...nums.splice(nums.length - k))
// }

// 方法二：reverse O(n^2)
const rotate = (nums, k) => {
  let temp, previous
  for (let i = 0; i < k; i++) {
    previous = nums[nums.length - 1]
    for (let j = 0; j < nums.length; j++) {
      temp = nums[j]
      nums[j] = previous
      previous = temp
    }
  }
}