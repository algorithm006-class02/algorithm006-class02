/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
  let i = 0
  let j = height.length - 1
  let max = 0
  while (i < j) {
    let m = height[i]
    let n = height[j]
    max = Math.max(max, Math.min(m, n) * (j - i))
    if (m < n) {
      i++
    } else {
      j--
    }
  }

  return max
};