class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        # return self.minPathSum_v1(grid)
        return self.minPathSum_v2(grid)
    def minPathSum_v1(self, grid):
    
        # 动态规划, 自顶向下
        # 1. 分治问题 problem(i, j) = sub()
        # 2. 定义状态数组: dp[i][j] 表示(i, j)位置的最小路径和
        # 3. 定义状态方程: 
            # if i == 0: dp[0][j] = dp[0][j - 1] + a[0][j]
            # if j == 0: dp[i][0] = dp[i - 1][0]  + a[i][0]
            # else: dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + a[i][j]
        
        dp = grid
        row_length, col_length = len(grid), len(grid[0])
        for i in range(1, row_length):
            dp[i][0] = dp[i - 1][0] + grid[i][0]
        for i in range(1, col_length):
            dp[0][i] = dp[0][i - 1] + grid[0][i]

        for i in range(1, row_length):
            for j in range(1, col_length):
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]

        return dp[-1][-1]

    