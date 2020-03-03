/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @param {number[]} prices
 * @return {number}
 */
// 方法一：贪心算法
// 贪心规则：只要 day1 比 day2 便宜，就 day1 买入，day2 卖出
const maxProfit = (prices) => {
  let profit = 0    
  for (let i = 1; i < prices.length; i++) {
    if (prices[i-1] < prices[i]) profit += prices[i] - prices[i-1]
  }
  return profit
};