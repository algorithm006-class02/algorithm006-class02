/*
 * @lc app=leetcode.cn id=190 lang=javascript
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
  let res = 0;
  for (let i = 0; i < 32; i++) {
    res <<= 1;
    res |= n & 1;
    n >>= 1;
  }
  // 去掉符号
  return res >>> 0;
};
// @lc code=end
