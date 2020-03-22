/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 * @param {number[]} nums
 * @return {number}
 */
// 方法一：贪心算法
// 贪心规则：每次都找当前范围内最大的数
const jump = (nums) => {
  let max = 0, prevMax = 0, count = 0
  for (let i = 0; i < nums.length-1; i++) {
    max = Math.max(max, i+nums[i])  
    if (i === prevMax) {
      count++
      prevMax = max
    }
  }
  return count
};

// 方法二：动态规划