/**
 * 151. Reverse Words in a String
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @param {string} s
 * @return {string}
 */
const reverseWords = (s) => {
  if (!s.length) return s
  let arr = s.split(' '), result = []
  for (let i = 0; i < arr.length; i++) {
    if (!arr[i].trim().length) continue
    result.unshift(arr[i])
  }
  return result.join(' ')
}