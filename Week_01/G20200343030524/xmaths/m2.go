package xmaths

/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func Twosum(nums []int, target int) []int {
	newnums := []int{0, 0}
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			if nums[i] == target-nums[j] {
				newnums[0] = i
				newnums[1] = j
			}
		}
	}
	return newnums
}

// @lc code=end
