package main

import "fmt"

func main() {
	data := [][]int{[]int{2}, []int{3,4}, []int{6,5,7}, []int{4,1,8,3}}

	fmt.Println(minimumTotal(data))
}

// 递归 已超时
func minimumTotal(triangle [][]int) int {
	if len(triangle) == 0 {
		return 0
	}

	return dfs(triangle, 0, 0)
}

func dfs(triangle [][]int, row, col int) int {

	if row == len(triangle) - 1 {
		return triangle[row][col]
	}

	lMin, rMin := dfs(triangle, row+1, col), dfs(triangle, row+1, col+1)

	if lMin < rMin {
		return lMin + triangle[row][col]
	}

	return rMin + triangle[row][col]
}

/*func minimumTotal(triangle [][]int) int {

	dp := triangle[len(triangle)-1]

	for i := len(triangle)-2; i >= 0; i-- {
		for j := 0; j <= i; j++ {

			if dp[j] < dp[j+1] {
				dp[j] = dp[j] + triangle[i][j]
			} else {
				dp[j] = dp[j+1] + triangle[i][j]
			}
		}
	}

	return dp[0]
}*/

/*func minimumTotal(triangle [][]int) int {

	count := len(triangle)
	if count == 0 {
		return 0
	}

	for i := count - 2; i >= 0; i-- {
		for 	 j := 0; j < len(triangle[i]); j++ {
			if triangle[i+1][j] < triangle[i+1][j+1] {
				triangle[i][j] += triangle[i+1][j]
			} else {
				triangle[i][j] += triangle[i+1][j+1]
			}

		}
	}

	return triangle[0][0]
}*/