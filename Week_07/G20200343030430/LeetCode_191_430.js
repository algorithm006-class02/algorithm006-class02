/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function (n) {
  let sum = 0
  while (n >= 1) {
    if (n & 1) sum++
    n = n >>> 1
    // console.log(n & 1, n)
  }
  return sum
};