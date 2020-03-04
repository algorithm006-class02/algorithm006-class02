/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  if (!prices.length) return 0
  let sum = 0
  let diff = 0
  for (let i = 0; i < prices.length - 1; i++) {
    diff = prices[i + 1] - prices[i]
    if (diff > 0) {
      sum += diff
    }
  }
  return sum
};