class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dp = grid
        for i in range(1, m):
            dp[i][0] = grid[i - 1][0] + grid[i][0]
        for j in range(1, n):
            dp[0][j] = grid[0][j - 1] + grid[0][j]

        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = grid[i][j] + min(dp[i - 1][j], dp[i][j - 1])
        
        return dp[-1][-1]