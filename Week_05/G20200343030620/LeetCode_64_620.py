class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        # 使用自低向上的方法进行动态规划求解
        #1. 重复子问题  2. 状态数组的定义 3. 状态转移方程
        if not grid:
            return 0
        dp=grid.copy()
        for i in range(len(grid)-1,-1,-1):
            for j in range(len(grid[i])-1,-1,-1):
                down=dp[i+1][j] if i+1<len(grid) else float('inf')
                right=dp[i][j+1] if j+1 <len(grid[i]) else float('inf') 
                if down==right==float('inf'):
                    dp[i][j]=grid[i][j]
                else:
                    dp[i][j]=min(down,right)+grid[i][j]
        return dp[0][0]