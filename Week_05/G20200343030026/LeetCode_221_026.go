func maximalSquare(matrix [][]byte) int {
	rows := len(matrix)
	if rows == 0 {
		return 0
	}
	cols := len(matrix[0])

	dp := make([]int, cols+1)
	var maxsqlen, prev int

	for i := 1; i <= rows; i++ {
		for j := 1; j <= cols; j++ {
			temp := dp[j]
			if matrix[i-1][j-1] == '1' {
				dp[j] = min(min(dp[j-1], prev), dp[j]) + 1
				maxsqlen = max(maxsqlen, dp[j])
			} else {
				dp[j] = 0
			}
			prev = temp
		}
	}

	return maxsqlen * maxsqlen
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func min(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
