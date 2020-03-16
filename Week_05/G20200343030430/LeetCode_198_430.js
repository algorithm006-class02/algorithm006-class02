/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  let preMax = 0 // 前一个偷到的最大值
  let curMax = 0 // 当前偷到的最大值
  for (let i = 0; i < nums.length; i++) {
    let temp = curMax
    // 当前不偷 vs 当前偷
    curMax = Math.max(curMax, preMax + nums[i])
    preMax = temp
  }
  return curMax
};