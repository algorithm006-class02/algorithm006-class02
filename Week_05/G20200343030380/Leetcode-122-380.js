/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @param {number[]} prices
 * @return {number}
 */
// 贪心算法
const maxProfit = (prices) => {
  if (prices.length <= 1) return 0
  let maxProfit = 0
  for (let i = 0; i < prices.length-1; i++) {
    if (prices[i] > prices[i+1]) continue
    maxProfit += prices[i+1] - prices[i]
  }
  return maxProfit
}