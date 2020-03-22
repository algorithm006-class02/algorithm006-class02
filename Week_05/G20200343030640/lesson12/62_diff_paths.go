package uniquePath

// 动态规划
// 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
// 对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1

func uniquePaths(m int, n int) int {
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
		for j := 0; j < n; j++ {
			if j == 0 || i == 0 {
				dp[i][j] = 1
			} else {
				dp[i][j] = dp[i][j-1] + dp[i-1][j]
			}
		}
	}
	return dp[m-1][n-1]
}
