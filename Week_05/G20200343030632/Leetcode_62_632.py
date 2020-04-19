import functools

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # return self.uniquePaths_v1(m, n)
        return self.uniquePaths_v2(m, n)

    def uniquePaths_v1(self, m: int, n: int) -> int:
        # 递归分治思想解决解决
        # 自底向上
        return self.helper(m - 1, n - 1)

    @functools.lru_cache
    def helper(self, row, col):
        if row == 0 or col == 0:
            return 1
        
        return self.helper(row - 1, col) + self.helper(row, col - 1)

    def uniquePaths_v2(self, m: int, n: int) -> int:
        # 动态规划
        # 1. 分析问题: 自顶向下, Problem(i, j) = sub_problem(i + 1, j) + sum_problem(i, j + 1) 子问题的路径数加和

        # 2. 定义状态数组: dp[i, j] 表示第i行j列的路径数, 最终的结果就是 dp[m - 1, n - 1]
        # 3. 定义状态转移矩阵: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
  

        dp = [[1 for col in range(n)] for row in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                # 要考虑各种边界
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[- 1][- 1]
    