/**
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/
 * @param {number[]} nums
 * @return {number}
 */
/**
 * 解题：
 * 此问题和 #198. House Robber 属于一个系列的问题，不同的是，这次的房屋排列是环形的，
 * 最后一个房子与第一个相邻, 也就是二者只能抢其一, 即：
 *   - 抢最后一个房子，nums[1...n], 最大金额为 dp1
 *   - 不抢最后一个房子，nums[0..n-1], 最大金额为 dp2
 *   - 最后比较 dp1, dp2 取较大者
 *   - dp1 与 dp2 的值使用 #198 题的解法即可
 */
const rob = (nums) => {
  if (!nums.length) return 0
  if (nums.length <= 2) return nums[1] ? Math.max(nums[0], nums[1]) : nums[0]
  let robTheLast = robSomeHouse(nums.slice(1))
  let notRobTheLast = robSomeHouse(nums.slice(0, nums.length-1))
  return Math.max(robTheLast, notRobTheLast)
}

const robSomeHouse = (nums) => {
  let prev1 = 0, prev2 = 0
  for (let num of nums) {
    let temp = prev1
    prev1 = Math.max(prev1, prev2 + num)
    prev2 = temp
  }
  return prev1
}