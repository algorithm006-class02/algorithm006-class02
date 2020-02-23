/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/
 * @param {number[]} digits
 * @return {number[]}
 */

// O(n)
var plusOne = function(digits) {
  for (let i = digits.length - 1; i >= 0; i--) {
    if (digits[i] < 9) {
      digits[i] += 1
      return digits
    }
    digits[i] = 0
  }
  digits.unshift(1)
  return digits
};