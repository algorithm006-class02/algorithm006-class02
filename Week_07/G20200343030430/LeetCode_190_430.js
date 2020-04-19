/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function (n) {
  let s = 0
  let i = 31
  while (i >= 0) {
    s = s << 1 >>> 0
    s += n & 1
    n = n >>> 1
    i--
  }
  return s
};
