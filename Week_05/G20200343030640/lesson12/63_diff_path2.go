package uniquePath

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	m := len(obstacleGrid)
	if m < 1 {
		return 0
	}
	n := len(obstacleGrid[0])
	if n < 1 {
		return 0
	}
	if 1 == obstacleGrid[0][0] {
		return 0
	}
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
		for j := 0; j < n; j++ {
			if 0 == i && 0 == j {
				dp[i][j] = 1
			} else if 0 == i && 0 != j {
				if 0 == obstacleGrid[i][j] {
					dp[i][j] = dp[i][j-1]
				}
			} else if 0 != i && 0 == j {
				if 0 == obstacleGrid[i][j] {
					dp[i][j] = dp[i-1][j]
				}
			} else {
				if 0 == obstacleGrid[i][j] {
					dp[i][j] = dp[i-1][j] + dp[i][j-1]
				}
			}
		}
	}
	return dp[m-1][n-1]
}
