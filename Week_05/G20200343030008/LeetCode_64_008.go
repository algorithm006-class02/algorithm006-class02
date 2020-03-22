//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。
//
// 示例:
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
//
// Related Topics 数组 动态规划

package main

func main() {

}

//leetcode submit region begin(Prohibit modification and deletion)
func minPathSum(grid [][]int) int {
	// 取纵向
	m := len(grid)
	// 取横向
	n := len(grid[0])

	if m == 0 {
		return 0
	}

	// 定义一个二维切片来存起点到该点的最小值
	dp := make([][]int, m)

	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
		for j := 0; j < n; j++ {
			var left, top int
			if i == 0 && j == 0 {
				dp[0][0] = grid[0][0]
				continue
			}
			if i == 0 {
				dp[0][j] = dp[0][j-1] + grid[i][j]
				continue
			} else {
				left = dp[i-1][j]
			}

			if j == 0 {
				dp[i][0] = dp[i-1][0] + grid[i][j]
				continue
			} else {
				top = dp[i][j-1]
			}
			dp[i][j] = min(left, top) + grid[i][j]
		}
	}
	return dp[m-1][n-1]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

//leetcode submit region end(Prohibit modification and deletion)
