学习笔记

```
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp = [0]*(n-1) + [1] + [0] if not obstacleGrid[m-1][n-1] else [0]*(n+1)
        for i in reversed(range(m)):
            for j in reversed(range(n)):
                dp[j] = dp[j] + dp[j+1] if not obstacleGrid[i][j] else 0
        return dp[0]
```
