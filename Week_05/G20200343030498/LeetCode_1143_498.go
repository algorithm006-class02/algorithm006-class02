package main

import "fmt"

func main() {

	fmt.Println(longestCommonSubsequence("abcde", "ace"))
}

/*func longestCommonSubsequence(text1 string, text2 string) int {

	row, col := len(text1), len(text2)
	dp := make([][]int, row)
	for i := 0; i < row; i++ {
		dp[i] = make([]int, col)
	}
	var tmpValue int

	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			tmpValue = 0

			if text1[i] == text2[j] {
				//左上+1
				if i > 0 && j > 0 {
					tmpValue = dp[i-1][j-1]
				}

				dp[i][j] = tmpValue + 1
			} else {
				//获取max(左,上)
				if i > 0 {
					tmpValue = dp[i-1][j]
				}

				if j > 0 && dp[i][j-1] >= tmpValue {
					tmpValue = dp[i][j-1]
				}

				dp[i][j] = tmpValue
			}
		}
	}

	return dp[row-1][col-1]
}*/

func longestCommonSubsequence(text1 string, text2 string) int {

	row, col := len(text1), len(text2)


	//init 0行和0列表示空字符
	dp := make([][]int, row+1)
	for i := 0; i < row+1; i++ {
		dp[i] = make([]int, col+1)
	}

	for i := 1; i <= row; i++ {
		for j := 1; j <= col; j++ {

			if text1[i-1] == text2[j-1] {
				//左上+1
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				//获取max(左,上)
				if dp[i][j-1] > dp[i-1][j] {
					dp[i][j] = dp[i][j-1]
				} else {
					dp[i][j] = dp[i-1][j]
				}
			}
		}
	}

	return dp[row-1][col-1]
}