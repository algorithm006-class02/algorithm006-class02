package xmaths

/*
 * @lc app=leetcode.cn id=153 lang=golang
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
func findMin(nums []int) int {
	sum := len(nums)
	return find(0, sum-1, nums, sum)
}
func find(left int, right int, nums []int, lenn int) int {
	if left == right {
		return nums[left]
	}
	if nums[0] > nums[lenn-1] {
		mid := (left + right) / 2
		if nums[mid] > nums[right] {
			return find(mid+1, right, nums, lenn)
		} else {
			return find(left, mid, nums, lenn)
		}
	} else {
		return nums[left]
	}
	return 0
}

// @lc code=end
