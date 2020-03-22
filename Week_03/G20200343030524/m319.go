package xmaths

/*
 * @lc app=leetcode.cn id=33 lang=golang
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
func search(nums []int, target int) int {
	lo := 0
	hi := len(nums) - 1
	for lo < hi {
		mid := (lo + hi) / 2
		if (nums[0] > target) && (nums[0] > nums[mid]) && (target > nums[mid]) {
			lo = mid + 1
		} else {
			hi = mid
		}
	}
	if lo == hi && nums[lo] == target {
		lo = -1
	}
	return lo
}

// @lc code=end
