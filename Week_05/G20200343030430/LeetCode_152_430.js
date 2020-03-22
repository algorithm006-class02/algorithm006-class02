/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function (nums) {
  if (!nums || !nums.length) return 0
  let n = nums.length
  let dpMax = new Array(n)
  let dpMin = new Array(n)
  let max = nums[0]
  dpMax[0] = dpMin[0] = max
  for (let i = 1; i < n; i++) {
    dpMax[i] = Math.max(dpMin[i - 1] * nums[i], nums[i], dpMax[i - 1] * nums[i])
    dpMin[i] = Math.min(dpMin[i - 1] * nums[i], nums[i], dpMax[i - 1] * nums[i])
    max = Math.max(max, dpMax[i])
  }
  console.log(dpMax, dpMin)
  return max
};