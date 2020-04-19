/**
 * 300. Longest Increasing Subsequence
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @param {number[]} nums
 * @return {number}
 */
/**
 * DP 数组 O(n^2)
const lengthOfLIS = (nums) => {
  if (!nums.length) return 0
  let dp = new Array(nums.length).fill(1)
  for (let i = 1; i < nums.length; i++) {
    for (let j = 0; j < i; j++) {
      if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1)
    }
  }
  return Math.max(...dp)
}
*/

/**
 * DP + 二分查找 O(nlogn)
 */
const lengthOfLIS = (nums) => {
  if (nums.length <= 1) return nums.length
  let tail = new Array(nums.length), result = 0
  for (let i = 0; i < nums.length; i++) {
    let left = 0, right = result
    while (left < right) {
      let mid = (left + right) >> 1
      if (tail[mid] < nums[i]) left = mid + 1
      else right = mid
    }
    tail[left] = nums[i]
    result == right && result++
  }
  return result
}