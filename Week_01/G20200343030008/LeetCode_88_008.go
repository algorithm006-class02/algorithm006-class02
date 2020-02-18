//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针

package main

func main() {

}

// 合并后排序，简单粗暴
/*
func merge(nums1 []int, m int, nums2 []int, n int) {
	nums1 = append(nums1[:m], nums2[:n]...)
	sort.Ints(nums1)
}
*/

// 双指针  前 -> 后
/*
func merge(nums1 []int, m int, nums2 []int, n int) {
	nNum1 := make([]int, m)
	copy(nNum1, nums1[:m])
	var i, j = 0, 0
	for i < m && j < n {
		if nNum1[i] < nums2[j] {
			nums1[i+j] = nNum1[i]
			i++
		} else {
			nums1[i+j] = nums2[j]
			j++
		}
	}
	if i == m {
		for j < n {
			nums1[i+j] = nums2[j]
			j++
		}
	}
	if j == n {
		for i < m {
			nums1[i+j] = nNum1[i]
			i++
		}
	}
}

*/

// 双指针  前 <- 后
// 排序尾数

//leetcode submit region begin(Prohibit modification and deletion)
func merge(nums1 []int, m int, nums2 []int, n int) {
	var i, j, p = m - 1, n - 1, m + n - 1

	for i >= 0 && j >= 0 {
		if nums1[i] < nums2[j] {
			nums1[p] = nums2[j]
			j--
			p--
		} else {
			nums1[p] = nums1[i]
			i--
			p--
		}
	}
	if i < 0 {
		for j >= 0 {
			nums1[p] = nums2[j]
			j--
			p--
		}
	}
	if j < 0 {
		for i >= 0 {
			nums1[p] = nums1[i]
			i--
			p--
		}
	}
}

//leetcode submit region end(Prohibit modification and deletion)
