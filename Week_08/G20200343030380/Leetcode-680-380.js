/**
 * 680. Valid Palindrome II
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 * @param {string} s
 * @return {boolean}
 */
const validPalindrome = (s, deleteOnce = true) => {
  if (s.length === 1) return true
  let left = 0, right = s.length - 1
  while(left < right && s[left] === s[right]) { left++; right-- }
  if (right <= left) return true
  if (deleteOnce) { return validPalindrome(s.slice(left, right), false) || validPalindrome(s.slice(left+1, right+1), false) }
  return false
}