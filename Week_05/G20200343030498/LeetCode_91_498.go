package main

import (
	"fmt"
)

func main() {

	s := "21312"
	fmt.Println(s[:2])
	fmt.Println(numDecodings("99"))
}

//1. dp[i][1] 表示 组合最后是连续的两个字母 dp[i][0]表示 组合最后不连续，单个字母解法总数
//2.
// if s[i] != 0
// dp[i][0] = dp[i-1][0] + dp[i-1[1]
// if s[i-1]s[i] <= 26
// dp[i][1] = dp[i-1][0]
//
// return dp[len(s)-1][0] + dp[len(s)-1][1]

//func numDecodings(s string) int {
//	l := len(s)
//	if l < 1 || string(s[0]) == "0" {
//		return 0
//	}
//
//	dp := make(map[int]map[int]int, l)
//	dp[0] = map[int]int{0:1,1:0}
//
//	for i := 1; i < l; i++ {
//		dp[i] = make(map[int]int, 2)
//
//		if string(s[i]) != "0" {
//			dp[i][0] = dp[i-1][0] + dp[i-1][1]
//		}
//
//		if string(s[i-1]) + string(s[i]) <= "26" {
//			dp[i][1] = dp[i-1][0]
//		}
//	}
//
//	return dp[l-1][0] + dp[l-1][1]
//}

/*func numDecodings(s string) int {
	l := len(s)
	if l < 1 || string(s[0]) == "0" {
		return 0
	}

	dp := make(map[int]int, l + 1)
	dp[-1] = 1
	dp[0] = 1

	for i := 1; i < l; i++ {

		if string(s[i]) == "0" && string(s[i-1]) != "1" && string(s[i-1]) != "2" {
			return 0
		}

		if string(s[i]) != "0" {
			dp[i] += dp[i-1]
		}

		if string(s[i-1]) + string(s[i]) <= "26" && string(s[i-1]) != "0" {
			dp[i] += dp[i-2]
		}
	}

	fmt.Println(dp)

	return dp[l-1]
}*/


// dp[i] 表示s[0...i]的编码总数
// if string(s[i-1]) + string(s[i]) <= "26" //与i-1组合
// 	dp[i] = dp[i-2]
// if s[i] != "0"
//  dp[i] += dp[i-1] //不与i-1组合

// return dp[l-1]


func numDecodings(s string) int {
	l := len(s)
	if l < 1 {
		return 0
	}

	dp := make(map[int]int, l + 1)
	dp[0] = 1 //空字段
	if s[0:1] == "0" {
		return 0
	}
	dp[1] = 1 //首个字段


	for i := 1; i < l; i++ {
		if s[i:i+1] == "0" && s[i-1:i] != "1" && s[i-1:i] != "2" {
			return 0
		}

		if s[i:i+1] > "0" {
			dp[i+1] += dp[i]
		}

		if s[i-1:i+1] <= "26" && s[i-1:i+1] >= "10" {
			dp[i+1] += dp[i-1]
		}
	}

	return dp[l]
}