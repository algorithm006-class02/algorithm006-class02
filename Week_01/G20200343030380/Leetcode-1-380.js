/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

// 方法一：暴力法, 两层循环 O(n^2)
//var twoSum = function(nums, target) {
//  for (let i = 0; i < nums.length - 1; i++) {
//    for (let j = i+1; j < nums.length; j++) {
//      if (nums[i] + nums[j] === target) return [i, j]
//    }
//  } 
//};

// 方法二：使用哈希表， O(n)
const twoSum = (nums, target) => {
  let result = {}
  for (let i = 0; i < nums.length; i++) {
    let distinct = target - nums[i]
    if (result.hasOwnProperty(distinct)) {
      return [i, result[distinct]]
    }
    result[nums[i]] = i
  }
}