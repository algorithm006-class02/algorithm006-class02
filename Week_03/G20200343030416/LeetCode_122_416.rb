=begin
  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
  设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
=end


#解法一、使用贪心算法
#将问题转化成看是否每天都买卖。如果后一天卖出前一天的股票的利润为正，则计入总利润，如果收益是亏损或零的则不计入总利润
def max_profit(prices)
  maxprofit = 0 
  for i in 0...prices.length - 1
    per_profit = prices[i + 1] - prices[i]
    maxprofit += per_profit if per_profit > 0
  end
  return maxprofit
end


#解法二、使用循环找出相邻的波峰波谷差，差值即为一次利润，再计算利润之和
def max_profit(prices)
  i, valley, peak, maxprofit = 0, prices[0], prices[0], 0
  while i < prices.length - 1
    #找到波谷
    # i < prices.length - 1的作用是避免数组越界
    while i < prices.length - 1 && prices[i] >= prices[i + 1]
      i += 1
    end
    valley = prices[i] 
    #找到相邻的波峰
    while i < prices.length - 1 && prices[i] <= prices[i + 1]
      i += 1
    end
    peak = prices[i]
    maxprofit += peak - valley
  end
  return maxprofit
end