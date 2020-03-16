/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 * @param {number[]} nums
 * @return {number}
 */
// DP: Iterative + memo
/** 
const rob = (nums) => {
  if (!nums.length) return 0
  const dp = new Array(nums.length+1).fill(0).fill(nums[0], 1, 2)
  for (let i = 2; i <= nums.length; i++) {
    dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1])
  }
  return dp[nums.length]
}
*/

// DP: Iterative + variables
const rob = (nums) => {
  if (!nums.length) return 0
  let prev1 = 0, prev2 = 0
  for (let x of nums) {
    let temp = prev1
    prev1 = Math.max(prev1, prev2 + x)
    prev2 = temp
  }
  return prev1
}