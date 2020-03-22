/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * @param {number[]} prices
 * @return {number}
 */
/** 暴力法 O(n^2)
const maxProfit = (prices) => {
  let maxProfit = 0
  for (let i = prices.length-1; i > 0; i--) {
    for (let j = 0; j < i; j++) {
      if (prices[j] > prices[i]) continue
      maxProfit = Math.max(maxProfit, prices[i] - prices[j])
    }
  }
  return maxProfit
}
*/

/** DP: Iterative + variables (bottom to up) O(n)
 * 重叠子问题：每一天的买入卖出选择是由前一天的选择而决定的，而前一天的选择是由更早的选择决定的
 * 明确状态：当前获得的利润
 * 确定DP函数定义：dp(i) 表示第 i 天卖出时所能获得的最大利润
 * 确定选择并择优： 第 i 天所能获得的最大利润dp[i]，就是 前一天卖出获得的最大利润，当天卖出获得的最大利润的较大者
 * 明确base case: dp[0] = 0; dp[1] = 0
 * DP方程：dp[i] = Math.max(dp[i-1], prices[i] - minprice)
 */
const maxProfit = (prices) => {
  if (prices.length <= 1) return 0
  let minPrice = prices[0], maxProfit = 0
  for (let i = 1; i < prices.length; i++) {
    minPrice = Math.min(prices[i], minPrice)  
    maxProfit = Math.max(maxProfit, prices[i] - minPrice)
  }
  return maxProfit
}