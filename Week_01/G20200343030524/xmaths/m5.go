package xmaths

import "fmt"

/*
 * @lc app=leetcode.cn id=26 lang=golang
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
func RemoveDuplicates(nums []int) int {
	n := len(nums)
	if n > 2 {
		m := len(nums)
		for i := 0; i < m; i++ {
			for j := i + 1; j < m; j++ {
				if nums[i] == nums[j] {
					nums = append(nums[:i], nums[i+1:]...)
					m--
					j--
				}
			}
		}
	} else if n == 2 {
		if nums[0] == nums[1] {
			nums = nums[:1]
		}
	}
	fmt.Println(nums)
	return len(nums)
}

// @lc code=end

/*
 * @lc app=leetcode.cn id=66 lang=golang
 *
 * [66] 加一
 */

// @lc code=start
func PlusOne(digits []int) []int {
	for i := len(digits) - 1; i >= 0; i-- {
		if digits[i] < 9 { // 当前位置不用进位，+1，然后直接返回
			digits[i]++
			return digits
		} else { // 要进位，当前位置置0
			digits[i] = 0
		}
	}
	return append([]int{1}, digits...)
}

// @lc code=end

/*
 * @lc app=leetcode.cn id=42 lang=golang
 *
 * [42] 接雨水
 */

// @lc code=start
func Trap(height []int) int {
	new_big := 0
	res_num := 0
	big_num := 0
	num_i := 0
	for i := 0; i < len(height); i++ {
		if height[i] >= big_num {
			big_num = height[i]
			num_i = i
		}
	}
	if num_i == 0 {
		height[0] = 0
		for i := 1; i < len(height); i++ {
			if height[i] >= height[0] {
				big_num = height[i]
				num_i = i
			}
		}
	}
	for i := 0; i < len(height)-1; i++ {
		num := height[i]
		if num_i == 0 {
			if num > new_big && num > 0 {
				// num = height[i] - new_big
				temp_num := 0
				for j := i + 1; j < len(height); j++ {
					if height[j] < num && height[j] >= new_big {
						temp_num = temp_num + (num - height[j])
					}
				}
				res_num = res_num + temp_num
				new_big = num
			}
		} else {
			if num > new_big && num > 0 && num_i != i {
				// num = height[i] - new_big
				temp_num := 0
				for j := i + 1; j < len(height); j++ {
					if height[j] < num && height[j] >= new_big {
						temp_num = temp_num + (num - height[j])
					}
				}
				res_num = res_num + temp_num
				new_big = num
			}

		}
	}
	return res_num
}

// @lc code=end
