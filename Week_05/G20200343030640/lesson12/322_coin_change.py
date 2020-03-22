# -*- coding: utf-8 -*-
"""
322. 零钱兑换
使用DP思想，转化为DP方程: 
f(amount) = min(f(amount-coins0), f(amount-coins1), f(amount-coins3))+1
"""

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        if len(coins) == 0:
            return -1
        
        dp = [float('inf') for i in range(amount+1)]
        dp[0] = 0
        for coin in coins:
            for i in range(coin, amount+1):
                dp[i] = min(dp[i], dp[i-coin]+1)
        print(dp)
        return dp[amount] if dp[amount] != float('inf') else -1
