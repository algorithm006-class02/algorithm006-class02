class Solution:
    def climbStairs(self, n: int) -> int:
        # 动态规划
        # 1. 分析问题: 一维的动态规划问题
        # 2. 定义状态数组: dp[i] 表示到达第i阶的方法数
        # 3. 定义状态方程: dp[i] = dp[i - 1] + dp[i - 2]
        if n < 2:
            return n
        dp = [0 for _ in range(n + 1)]
        dp[1], dp[2] = 1, 2

        for i in range(3, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        
        return dp[-1]