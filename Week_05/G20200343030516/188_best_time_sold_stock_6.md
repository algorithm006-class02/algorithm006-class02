188. 买卖股票的最佳时机 IV
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [2,4,1], k = 2
输出: 2
解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2:

输入: [3,2,6,5,0,3], k = 2
输出: 7
解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

### solution

+ 1 需要判断当前K  > len(price) /2 ? K = inf : normol
+ 状态压缩：
每次只更新需要 K *（在手，不在手） 个状态


```python
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:

        def maxProfit_k_inf(prices):
            if not prices:
                return 0
            res = 0
            pre = prices[0]
            for num in prices[1:]:
                if num > pre:
                    res += num - pre
                pre = num
            return res

        if k > len(prices)/ 2:
            return maxProfit_k_inf(prices)
        
        dp = [[0,-float('inf')] for _ in range(k+1)]
        for price in prices:
            for k in range(1,k+1):
                    dp[k][0] = max(dp[k][0], dp[k][1] + price)
                    dp[k][1] = max(dp[k][1], dp[k-1][0] - price)
        return dp[-1][0]

```