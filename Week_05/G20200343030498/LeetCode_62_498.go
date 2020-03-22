package main

func main() {

}

func uniquePaths(m int, n int) int {

	dp := make([]int, m)
	dp[m-1] = 1

	for i := n-1; i >= 0; i-- {
		for j := m-1; j>= 0; j-- {
			if j < m-1 {
				dp[j] = dp[j] + dp[j+1]
			}
		}
	}

	return dp[0]
}