/**
 * 8. String to Integer (atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @param {string} str
 * @return {number}
 */
const myAtoi = (str) => {
  let s = str.trim()
  if (!s.length) return 0

  digits = s.match(/^[-|+]?[0-9]+/)
  if (!digits) return 0

  let num = Number(digits[0])
  if (Number.isNaN(num)) return 0

  const INT_MAX = Math.pow(2, 31) - 1, INT_MIN = - Math.pow(2, 31)
  if (num > INT_MAX) return INT_MAX
  if (num < INT_MIN) return INT_MIN

  return num
}