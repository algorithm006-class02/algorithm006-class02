package xmaths

import "fmt"

/*
 * @lc app=leetcode.cn id=189 lang=golang
 *
 * [189] 旋转数组
 */

// @lc code=start
func Rotate(nums []int, k int) {
	n := len(nums)
	for i := 0; i < k; i++ {
		arr := nums[n-1:]
		nums = append(arr, nums[:n-1]...)
		// fmt.Println(nums)
	}
	// nums = append(nums[k:], nums[:k]...)
	fmt.Println(nums)
}

// @lc code=end

/*
 * @lc app=leetcode.cn id=88 lang=golang
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
func Merge(nums1 []int, m int, nums2 []int, n int) {
	// j := m - 1
	// k := n - 1
	// for i := m + n - 1; i >= 0; i-- {
	// 	// fmt.Println(i)
	// 	if k >= 0 {

	// 		// nums1[i] = nums2[k]
	// 		// k--
	// 		// i--
	// 		if n >= m &&  {
	// 			k--
	// 		}
	// 		fmt.Println(i)
	// 	}
	// 	if j >= 0 {
	// 		// nums1[i] = nums1[j]
	// 		// j--
	// 		if n < m {

	// 		}
	// 		fmt.Println(i)
	// 	}
	// }
	var i, j int

	nums1 = nums1[0:m]

	for len(nums2) != 0 && i < len(nums1) {
		if nums1[i] >= nums2[0] {
			nums1 = append(nums1[:i+1], nums1[i:]...)
			nums1[i] = nums2[j]
			// 删除nums2的第一个元素
			nums2 = nums2[1:]
			// nums向后移动两个元素
		} else {
			i++
		}
	}
	for len(nums2) != 0 {
		nums1 = append(nums1, nums2[0])
		nums2 = nums2[1:]
	}

	fmt.Println(nums1)
}

// @lc code=end
