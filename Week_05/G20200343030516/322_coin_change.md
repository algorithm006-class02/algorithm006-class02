### description
322. 零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1

### solution
i: 0 -> amount
状态转移方程：
dp[i] = min( dp[i - coin] for coin in coins  ) + 1 

边界条件与初始化：
因为最小，dp 初始为最大数，
边界 dp[0] = 0 已知

```python
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0] + [float('inf')]*amount
        for coin in coins:
            for i in range(coin,amount+1):
                dp[i] = min(dp[i],dp[i-coin] +1)
        return dp[-1] if dp[-1] != float('inf') else -1

```
