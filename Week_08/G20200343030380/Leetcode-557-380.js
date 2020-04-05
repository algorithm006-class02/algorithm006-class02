/**
 * 557. Reverse Words in a String III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * @param {string} s
 * @return {string}
 */
/**
 * 方法一：调用库函数
 */
const reverseWords = (s) => {
  if (s.length <= 1) return s
  return s.split('').reverse().join('').split(/\s+/).reverse().join(' ')
}
