/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 * @param {number} x
 * @return {number}
 */
const mySqrt = (x) => {
  if (x <= 1) return x    
  let left = 1, right = Math.floor(x/2)
  while (left <= right) {
    let mid = Math.floor((left + right) / 2)
    if (mid * mid <= x && x < (mid+1) * (mid+1)) return mid
    if (mid * mid < x) {
      left = mid + 1
    } else {
      right = mid - 1
    }
  }
};