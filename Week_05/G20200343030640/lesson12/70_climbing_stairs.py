# -*- coding: utf-8 -*-
"""
70. 爬楼梯
每次你可以爬 1 或 2 个台阶
使用DP思想，转化为DP方程: f(n) = f(n-1)+f(n-2)
"""

class Solution:
    def climbStairs(self, n: int) -> int:
        if n<=1:
            return n
        dp = [1 for i in range(n+1)]

        for i in range(2, n+1):
            dp[i] = dp[i-1]+dp[i-2]
        # print(dp)
        return dp[n]