/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function (nums, k) {
  if (nums.length < 2) return nums
  let arr = []
  let max = nums[0]
  for (let i = 0; i <= nums.length - k; i++) {
    max = nums[i]
    for (let j = i + 1; j < i + k; j++) {
      let n = nums[j]
      if (n > max) {
        max = n
      }
    }
    arr.push(max)
  }

  return arr
};