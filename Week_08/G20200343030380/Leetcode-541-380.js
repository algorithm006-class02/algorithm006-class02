/**
 * 541. Reverse String II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
/**
 * 方法一：遍历字符串数组，每次遍历走 2*k 步，循环体内将 [i..i+k-1] 的字符依次反转
 */
const reverseStr = (s, k) => {
  let len = s.length
  if (len <= 1) return s 
  let arr = s.split('')
  for (let i = 0; i < len; i += 2*k) {
    let start = i, end = Math.min(i + k - 1, len - 1)
    while(start < end) [arr[start++], arr[end--]] = [arr[end], arr[start]]
  }
  return arr.join('')
}

/**
 * 方法二：使用字符串 reverse() 方法 + 奇偶性判断是否反转
 */
const reverseStr = (s, k) => {
  if (s.length <= 1) return s
  let arr = s.split(''), result = ''
  for (let i = 0; i < s.length; i += k) {
    if ((i/k) % 2 === 0) result += arr.slice(i, i+k).reverse().join('')
    else result += s.slice(i, i+k)
  }
  return result
}