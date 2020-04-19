/**
 * 190. Reverse Bits
 * https://leetcode-cn.com/problems/reverse-bits
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
const reverseBits = (n) => {
  let result = 0
  for (let i = 0; i < 32; ++i) {
    result = (result << 1) + (n & 1)
    n >>= 1
  }    
  console.log(result)
  return result >>> 0
}