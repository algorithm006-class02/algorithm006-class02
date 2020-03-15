
class Solution:
    def fib(self, N: int) -> int:
        return self.fib_v2(N)
    def fib_v1(self, N: int) -> int:
        # 动态规划思路:
        # 1. 分析问题: fib(n) = fib(n - 1) + fib(n - 2), n > 1
        # 2. 定义状态数组: dp[i] 表示从0开始到i fib(i)的值
        # 3. 状态转移方程: dp[i] = dp[i - 1] + dp[i - 2]
        if N <= 1:
            return N
        
        dp = [0 for i in range(0, N + 1)]
        dp[1] = 1
        
        for i in range(2, N + 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        
        return dp[N]

    
    def fib_v2(self, N: int) -> int:
        # 不用存储所有状态, 只存最近两个就行
        if N <= 1:
            return N
        # 0, 1
        pre, ppre = 1, 0
        res = 0
        for i in range(2, N + 1):
            res = pre + ppre
            ppre = pre
            pre = res
        return pre