/**
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 * @param {number[]} nums
 * @return {number}
 */
const maxProduct = (nums) => {
  if (nums.length <= 1) return nums[0]
  let iMax = nums[0], iMin = nums[0], max = nums[0]
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] < 0) [iMax, iMin] = [iMin, iMax]
    iMax = Math.max(nums[i], nums[i] * iMax)
    iMin = Math.min(nums[i], nums[i] * iMin)
    max = Math.max(iMax, max)
  }
  return max
}

/** DP 
 * 和最大子序列的和题目相似，我们首先可以想到的DP方程是: nums[i] = Math.max(nums[i], nums[i] * nums[i-1])
 * 因为有负数的存在，所以我们需要记录最大值与最小值，当出现负数时，最大值最小值互换
 * 最终的最大值即为结果
 */

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */