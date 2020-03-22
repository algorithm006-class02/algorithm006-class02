# -*- coding: utf-8 -*-
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid or len(grid) == 0:
            return 0
        
        m = len(grid)
        n = len(grid[0])

        for i in range(1, m):
            grid[i][0] += grid[i-1][0]
        for i in range(1, n):
            grid[0][i] += grid[0][i-1]
        
        # 从[1,1]开始处理
        for r in range(1, m):
            for c in range(1, n):
                grid[r][c] += min(grid[r][c-1], grid[r-1][c])
        
        print(grid)
        return grid[m-1][n-1]
