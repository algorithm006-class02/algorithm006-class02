/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function (num) {
  if (num < 2) return true
  let k = Math.floor(num / 2)
  while (k * k > num) {
    k = Math.floor((k + num / k) / 2)
  }
  return k * k === num
};