/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function (nums) {
  if (!nums.length) return true
  let dis = nums.length - 1
  for (let i = nums.length - 1; i >= 0; i--) {
    if (nums[i] + i >= dis) {
      dis = i
    }
  }
  return dis === 0
};