package xmaths

/*
 * @lc app=leetcode.cn id=169 lang=golang
 *
 * [169] 多数元素
 */

// @lc code=start
func majorityElement(nums []int) int {
	nums_map := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		if nums_map[nums[i]] == 0 {
			nums_map[nums[i]] = 1
		} else {
			nums_map[nums[i]]++
		}
	}
	temp_k := 0
	temp_v := 0
	for k, v := range nums_map {
		if temp_v < v {
			temp_k = k
			temp_v = v
		}
	}
	return temp_k
}

// @lc code=end
