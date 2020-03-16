package main

import "fmt"

func main() {
	data := []int{1,2,3,1}

	fmt.Println(rob(data))
}

//a[i][0] 表示第i个不偷时最高的金额  a[i][1] 表示第i个偷时最高的金额 return max(a[n-1][0], a[n-1][1])
// a[i][0] = mqx(a[i-1][0], a[i-1][1])
// a[i][1] = a[i-1][0] + nums[i]
//func rob(nums []int) int {
//	len := len(nums)
//	if len == 0 {
//		return 0
//	}
//
//	dp := make(map[int]map[int]int, len)
//	dp[0] = map[int]int{0:0, 1:nums[0]}
//
//	for i := 1; i < len; i++ {
//		if dp[i-1][1] > dp[i-1][0] {
//			dp[i] = map[int]int{0:dp[i-1][1], 1:dp[i-1][0]+nums[i]}
//		} else {
//			dp[i] = map[int]int{0:dp[i-1][0], 1:dp[i-1][0]+nums[i]}
//		}
//	}
//
//	if dp[len-1][0] > dp[len-1][1] {
//		return dp[len-1][0]
//	}
//
//	return dp[len-1][1]
//}

//a[i] 表示第i个必偷时最高的金额
// a[i] = max(a[i-1], a[i-2] + nums[i])
func rob(nums []int) int {
	len := len(nums)
	if len == 0 {
		return 0
	}

	dp := make(map[int]int, len)
	dp[-1] = 0
	dp[0] = nums[0]
	result := nums[0]

	for i := 1; i < len; i++ {
		if dp[i-1] > dp[i-2] + nums[i] {
			dp[i] = dp[i-1]
		} else {
			dp[i] = dp[i-2] + nums[i]
		}

		if dp[i] > result {
			result = dp[i]
		}
	}

	return result
}

//优化版本
// 使用prevMax和currentMax分别代替a[i-1]和a[i-2
//func rob(nums []int) int {
//	prevMax := 0
//	currentMax := 0
//
//	for i := 0; i < len(nums); i++ {
//		temp := currentMax
//		if currentMax < prevMax + nums[i] {
//			currentMax = prevMax + nums[i]
//		}
//		prevMax = temp
//	}
//
//	return currentMax
//}
