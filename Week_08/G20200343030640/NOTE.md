学习笔记

"""bash
63. 不同路径 II

分析状态转移方程： 

obstacleGrid: M * N
dp[i][j]: 从(0,0)到(i,j)不同路径条数

若obstacleGrid[0][0] == 1: return 0
若obstacleGrid[0][0] == 0: dp[0][0] = 1

若obstacleGrid[0][j] == 0:
    dp[i][j] == dp[i][j-1]
否则: dp[i][j] = 0

若obstacleGrid[i][0] == 0:
    dp[i][j] == dp[i-1][j]
否则: dp[i][j] = 0

若obstacleGrid[i][j] == 0:
    dp[i][j] == dp[i-1][j] + dp[i][j-1]
否则: dp[i][j] = 0

"""