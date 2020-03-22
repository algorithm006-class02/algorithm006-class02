/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * @param {number[]} nums
 * @return {number}
 */
// 二分查找
// 思路：先找到有序数列部分，如果是前部分有序，那就说明后部分无序，最小值在后部分，反之则在前面
//const findMin = (nums) => {
//  let left = 0, right = nums.length-1
//  // 如果是单调有序，直接返回
//  if (nums[0] <= nums[right]) return nums[0]
//  // 如果是部分有序,就二分查找
//  while (left <= right) {
//    if (nums[0] > nums[left]) return nums[left]
//    let mid = Math.floor((left + right) / 2)
//    if (nums[left] < nums[mid]) {
//      left = mid + 1
//    } else if (left === mid) {
//      left += 1
//    } else {
//      right = mid
//      left += 1
//    }
//  }
//};


// 二分查找
// 思路：如果中间值比右边界值大，说明拐点出现在后半部分，否则在左半部分
const findMin = (nums) => {
  let left = 0, right = nums.length-1
  while (left < right) {
    let mid = Math.floor((left + right) / 2)
    if (nums[mid] > nums[right]) left = mid + 1
    else right = mid
  }
  return nums[left]
}