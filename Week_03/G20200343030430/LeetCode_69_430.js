/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function (x) {
  if (x <= 1) return x
  // 牛顿迭代
  let k = x
  let k2 = (k + x / k) / 2
  while (Math.abs(k - k2) >= 1) {
    k = k2
    k2 = (k + x / k) / 2
  }
  return Math.floor(k2)
};