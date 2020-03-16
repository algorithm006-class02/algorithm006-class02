from typing import List
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        return self.minimumTotal_v1(triangle)
    def minimumTotal_v1(self, triangle: List[List[int]]) -> int:
        # 动态规划
        # 1. 分析问题: 
        # 2. 定义状态数组: dp[i][j] 表示第[i, j]位置的最小路径和
        # 3. 定义状态方程: dp[i][j] = Min(dp[i - 1][j], dp[i - 1][j - 1]) + a[i][j]

        dp = triangle
        row_length = len(dp)
        for i in range(1, row_length):
            for j in range(0, i + 1):
                if j == i:
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j]
                elif j == 0:
                    dp[i][j] = dp[i - 1][j] + triangle[i][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j]
        return min(dp[-1])
