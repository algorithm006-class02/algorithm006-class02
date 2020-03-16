package main

import (
	"fmt"
	"math"
)

func main() {
	//data := []int{-2,1,-3,4,-1,2,1,-5,4}
	data := []int{-2,1}

	fmt.Println(maxSubArray(data));
}

// 1. 分治（子问题）
// 2. 状态数组定义  dp[i]表示nums中以nums[i]结尾的最大子序和
// 3. dp方程：
//   if dp[i-1] > 0 dp[i] = dp[i-1] + a[i] else dp[i] = a[i]
func maxSubArray(nums []int) int {
	length := len(nums)
	if length < 1 {
		return 0
	}
	dp, max := nums[0], math.MinInt64
	for i := 1; i < length; i++ {
		if dp > 0 {
			dp += nums[i]
		} else {
			dp = nums[i]
		}

		if dp > max {
			max = dp
		}
	}

	return max
}

/*func maxSubArray(nums []int) int {

	tmpValue, max := 0, nums[0]

	for i := 0; i < len(nums); i++ {
		tmpValue = 0
		for j := i; j < len(nums); j++ {
			tmpValue += nums[j]
			fmt.Println(tmpValue, max)
			if tmpValue > max {
				max = tmpValue
			}
		}
	}

	return max
}*/

/*func maxSubArray(nums []int) int {
	length := len(nums)
	if length < 1 {
		return 0
	}
	max := nums[0]
	for i := 1; i < length; i++ {
		if nums[i-1] > 0 {
			nums[i] += nums[i-1]
		}

		if nums[i] > max {
			max = nums[i]
		}
	}

	return max
}*/