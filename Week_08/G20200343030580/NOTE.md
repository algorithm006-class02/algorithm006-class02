### 不同路径2 的状态转移方程

````

dp[m-1] = obstacleGrid[i][m - 1] == 1 || path[m - 1] == 0 ? 0 : 1

dp[j] = obstacleGrid[i][j] == 1 ? 0 : path[j] + path[j + 1];


````