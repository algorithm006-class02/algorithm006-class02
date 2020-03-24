/**
 * 191. Number of 1 Bits
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * @param {number} n - a positive integer
 * @return {number}
 */
/**
 * 方法一：根据消除末尾1(n = n & (n-1))的个数
 */
const hammingWeight = (n) => {
  let count = 0
  while (n) { count++; n = n & (n-1) }    
  return count
}

/**
 * 方法二：按位与1进行取&操作
const hammingWeight = (n) => {
  let count = 0, mask = 1
  for (let i = 0; i < 32; ++i) {
    if ((n & mask) != 0) {console.log(n); ++count}
    mask <<= 1
  }
  return count
}
*/

/**
 * 方法三：toString(2)转二进制 + 正则匹配
 * refer: https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Number/toString
const hammingWeight = (n) => {
  return (n.toString(2).match(/1/g) || []).length
}
 */

/**
 * 方法四：十进制转二进制，统计1的个数
const hammingWeight = (n) => {
  let count = 0
  while(n) {
    count += n % 2
    n >>= 1
  }
  return count
}
 */