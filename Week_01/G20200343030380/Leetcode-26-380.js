/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @param {number[]} nums
 * @return {number}
 */

// 方法一：遍历数组，逐个删除重复项  O(n^2)
// const removeDuplicates = (nums) => {
//   for(let i = 0; i < nums.length - 1; i++) {
//     while (nums[i] === nums[i+1]) {
//       nums.splice(i+1, 1)
//     }
//   }
//   return nums.length
// };

// 方法二：快慢指针 O(n)
const removeDuplicates = (nums) => {
  let slow = 0
  for (let fast = 1; fast < nums.length; fast++) {
    if (nums[slow] != nums[fast]) {
      nums[++slow] = nums[fast]
    }
  }
  return ++slow
}