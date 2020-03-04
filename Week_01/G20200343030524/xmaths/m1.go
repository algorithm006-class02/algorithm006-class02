package xmaths

import "fmt"

/*
 * @lc app=leetcode.cn id=283 lang=golang
 *
 * [283] 移动零
 */

// @lc code=start

func MoveZeroes(nums []int) {
	// 获取数组的长度
	sum := len(nums)
	// 记录有多少个为0的值
	mZero := 0
	//循环数组
	for i := 0; i < sum; i++ {
		// 如果数组元素中有
		// fmt.Println(i)
		if nums[i] == 0 {
			mZero++
		} else {
			nums[i-mZero] = nums[i]
		}
	}
	for j := 1; j <= mZero; j++ {
		nums[sum-j] = 0
	}
	fmt.Println(nums)
}

// @lc code=end
