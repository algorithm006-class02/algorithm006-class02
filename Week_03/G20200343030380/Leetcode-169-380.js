/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 * @param {number[]} nums
 * @return {number}
 */
// 方法一：哈希表 O(n)
const majorityElement = (nums) => {
  let result = {}
  let length = nums.length
  for (let i = 0; i < length; i++) {
    result[nums[i]] = result[nums[i]] + 1 || 1
    if (result[nums[i]] > length / 2) return nums[i]
  }
};

// 方法二：排序 O(nlogn)
// const majorityElement = (nums) => {
//   return nums.sort((a,b) => a - b)[Math.floor(nums.length / 2)]
// }