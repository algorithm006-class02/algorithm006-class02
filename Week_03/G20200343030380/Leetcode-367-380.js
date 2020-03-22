/**
 * 367. Valid Perfect Square
 * https://leetcode.com/problems/valid-perfect-square/
 * @param {number} num
 * @return {boolean}
 */
// 二分查找
const isPerfectSquare = (num) => {
  if (num === 1) return true
  let left = 1, right = Math.floor(num/2)
  while (left <= right) {
    let mid = Math.floor((left + right) / 2)
    if (mid * mid === num) return true
    if (mid * mid < num) {
      left = mid + 1
    } else {
      right = mid - 1
    }
  }  
  return false
}