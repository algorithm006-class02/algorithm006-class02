/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function (digits) {
  let arr = digits // digits.slice()
  for (let i = digits.length - 1; i >= 0; i--) {
    if (digits[i] == 9) {
      arr[i] = 0
    } else {
      arr[i] = digits[i] + 1
      return arr
    }
  }
  // arr.unshift(1)
  arr = new Array(digits.length + 1).fill(0)
  arr[0] = 1
  return arr
};