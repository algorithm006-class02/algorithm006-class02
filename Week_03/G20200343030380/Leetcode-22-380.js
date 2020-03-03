/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 * @param {number} n
 * @return {string[]}
 */
// 递归
const generateParenthesis = (n, result = []) => {
  const _generator = (left, right, str) => {
    if (left == n && right == n) { result.push(str); return }  
    if (left < n) _generator(left + 1, right, str + '(')      
    if (right < left) _generator(left, right + 1, str + ')')
  }
  _generator(0, 0, '')
  return result
};