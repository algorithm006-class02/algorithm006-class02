/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
// solution1 O(nlogn): normal search + binary search
//const searchMatrix = (matrix, target) => {
//  if (!matrix.length) return false
//  
//  let row = 0
//  if (matrix.length > 1) {
//    for (let i = 0; i < matrix.length; i++) {
//      if (matrix[i][0] === target) return true
//      if (matrix[i][0] < target) { 
//        row = i
//      } else break
//    }
//  }
//  let nums = matrix[row]
//  let left = 0, right = nums.length-1
//  while (left <= right) {
//    let mid = Math.floor((left + right)/2)
//    if (target === nums[mid]) return true
//    if (target < nums[mid]) {
//      right = mid - 1  
//    } else {
//      left = mid + 1
//    }
//  }
//  return false
//};

// solution2 O(logmn): once binary search
// 题给的二维有序数组可以通过一维有序数组的索引进行二分查找
// 二维转一维：row = index / n; col = index % n  (n为元素所在数组的长度，index为该元素在一位数组的索引)
const searchMatrix = (matrix, target) => {
  if (!matrix.length) return false
  let m = matrix.length, n = matrix[0].length, left = 0, right = m*n-1 
  while (left <= right) {
    let mid = Math.floor((left + right) / 2)
    let row = Math.floor(mid/n), col = Math.floor(mid%n)
    if (target === matrix[row][col]) return true
    if (target < matrix[row][col]) {
      right = mid - 1  
    } else {
      left = mid + 1
    }
  }
  return false
}