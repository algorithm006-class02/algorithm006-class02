/**
 * 231. Power of Two
 * https://leetcode-cn.com/problems/power-of-two/
 * @param {number} n
 * @return {boolean}
 */
/**
 * 思路：如果一个数是2的幂次方的话，则它的二进制中有且只有1个1
 */
const isPowerOfTwo = (n) => {
  return n > 0 && (n & (n-1)) === 0
}