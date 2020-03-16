/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 * @param {number[]} nums
 * @return {boolean}
 */
/* 贪心算法
 * 贪心规则：每次都取局部最优，也就是数值最大的数，超过或者达到last index即为 true
 *
 */
const canJump = (nums) => {
  let max = nums[0] 
  for (let i = 0; i < nums.length; i++) {
    if (max < i) return false
    max = Math.max(i+nums[i], max)
    if (max >= nums.length-1) return true
  }
};