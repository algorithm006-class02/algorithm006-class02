package main

import (
	"fmt"
)

func main() {
	data := [][]int{[]int{1,3,1},[]int{1,5,1}, []int{4,2,1}}

	fmt.Println(minPathSum(data))
}

func minPathSum(grid [][]int) int {
	row := len(grid)
	if row < 1 {
		return 0
	}

	col := len(grid[0])

	for i := row-1; i >= 0; i-- {
		for j := col-1; j >= 0; j-- {

			if i != row-1 && j != col-1 {
				grid[i][j] += min(grid[i+1][j], grid[i][j+1])
			} else if i != row-1 {
				grid[i][j] += grid[i+1][j]
			} else if j != col-1 {
				grid[i][j] += grid[i][j+1]
			}
		}
	}

	fmt.Println(grid)

	return grid[0][0]
}

func min(a, b int) int {
	if a < b {
		return a
	}

	return b
}

// 1. 递归 minPathSum(grid, [i ,j]) = grid[i, j] + min(minPathSum(grid, [i+1,j]), minPathSum(grid, [i,j+1]))
// 2.  DP
// dp[i][j]表示该位置到右下角的最小路径
// dp[i][j] = min(dp[i+1][j], dp[i][j+1]) + grid[i][j] return dp[0][0]
// 转为一维dp
// dp[j] = min(dp[j], dp[j+1]) + grid[i][j] return dp[0]

/*func minPathSum(grid [][]int) int {
	row := len(grid)
	if row < 1 {
		return 0
	}

	col := len(grid[row-1])
	dp := make([]int, col + 1)
	dp[col-1] = grid[row-1][col-1]
	dp[col] = math.MaxInt64 //放在最后一位，不用判断右边临界值
	for j := col-2; j >= 0; j-- {
		dp[j] = dp[j+1] + grid[row-1][j]
	}

	for i := row - 2; i >= 0; i-- {
		for j := col-1; j >=0; j-- {

			if dp[j] > dp[j+1] {
				dp[j] = dp[j+1] + grid[i][j]
			} else {
				dp[j] = dp[j] + grid[i][j]
			}
		}
	}

	return dp[0]
}*/
