/**
 * 50. Pow(x,n)
 * https://leetcode.com/problems/powx-n/
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
// 方法一：暴力法，直接计算 n 次, O(n), 当 n 很大时 Time Limit Exceeded
//const myPow = (x, n) => {
//  if (n === 0) return 1
//  if (n === 1) return x
//  let result = 1
//  for (let i = 1; i <= Math.abs(n); i++) {
//    result *= x  
//  }
//  if (n < 0) {
//    result = 1 / result
//  }
//  return result
//};

// 方法二：分治 O(logn)
// pow(2, 10) 就等于 pow(2,5) * pow(2,5) .... 
// x = 2; n = 10; => 2^5 * 2^5; => 2^2*2^2*2 * 2^2*2^2*2; => 2*2*2*2*2*2 * 2*2*2*2*2*2
const myPow = (x, n) => {
  let result = fastPow(x, Math.abs(n))
  return n < 0 ? 1 / result : result
}
const fastPow = (x, n) => {
  if (n === 0) return 1.0
  if (n === 1) return x
  let half = fastPow(x, Math.floor(n/2))
  if (n % 2 === 0) {
    return half * half
  } else {
    return half * half * x
  }
}