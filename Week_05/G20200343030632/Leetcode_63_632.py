from typing import List
import functools
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        return self.uniquePathsWithObstacles_v1(obstacleGrid)
        # return self.uniquePathsWithObstacles_v1(obstacleGrid)
    
    def uniquePathsWithObstacles_v1(self, obstacleGrid: List[List[int]]) -> int:
        # 分治
        row_index = len(obstacleGrid) - 1
        col_index = len(obstacleGrid[0]) - 1
        return self.helper(row_index, col_index, obstacleGrid)

    def helper(self, row: int, col: int, obstacleGrid: List[List[int]]) -> int:
        if row < 0 or col < 0:
            return 0
        # 遇到障碍物
        if obstacleGrid[row][col] == 1:
            return 0
        if row == 0 and col == 0:
            return 1
        return self.helper(row - 1, col, obstacleGrid) + self.helper(row, col - 1, obstacleGrid)

    def uniquePathsWithObstacles_v2(self, obstacleGrid: List[List[int]]) -> int:
        # 动态规划
        # 1. 划分子问题: Problem(i, j) = sub_problem(i + 1, j) + sub_problem(i, j + 1)
        # 2. 定义状态数组: dp[i][j] 表示在从棋盘坐标(0, 0) 到坐标(i, j)的路径数目
        # 3. 定义状态转移方程: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        # 4. 判断遇到障碍物的情况
        if not obstacleGrid:
            return 0
        
        row_length = len(obstacleGrid)
        col_length = len(obstacleGrid[0])
        dp = [[1 for _ in range(col_length)] for _ in range(row_length)]
        
        for i in range(1, row_length):
            dp[i][0] = dp[i - 1][0] * (1 - obstacleGrid[i][0])
        for j in range(1, col_length):
            dp[0][j] = dp[0][j - 1] * (1 - obstacleGrid[0][j])
        for i in range(1, row_length):
            for j in range(1, col_length):
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) * (1 - obstacleGrid[i][j])
        
        return dp[-1][-1]

