/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function (str) {
  let arr = str.replace(/^\s*/, '').match(/^(\+|-)?\d+/)
  if (!arr) return 0
  let n = +arr[0]
  let max = Math.pow(2, 31)
  if (n >= max) return max - 1
  if (n < -max) return -max
  return n
};