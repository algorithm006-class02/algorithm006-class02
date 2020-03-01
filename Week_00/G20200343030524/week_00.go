package main

import "fmt"

/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	var p = []int{0, 1}
	for i := 0; i < len(nums); i++ {
		for j := 0; j < len(nums); j++ {
			if nums[j] == target-nums[i] {
				p[0] = j
				p[1] = i
			}
		}
	}
	return p
}

// @lc code=end

func main() {
	var a = []int{1, 9, 8, 3}
	b := 10
	c := twoSum(a, b)
	fmt.Println(c)
}
