//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针

package main

import "fmt"

func main() {
	// nums := []int{0, 1, 0, 3, 12}
	nums := []int{0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
	moveZeroes1(nums)
	fmt.Println(nums)
}

// 1. 暴力法，开新数组
// 时间复杂度 O(n), 空间复杂度O(n)
func moveZeroes1(nums []int) {
	tmp := make([]int, len(nums))
	count := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			tmp[count] = nums[i]
			count++
		}
	}
	copy(nums, tmp)
}

// 2. 双指针，快慢指针，慢指针指向非零，快指针遍历数组
// 时间复杂度 O(n), 空间复杂度O(1)
func moveZeroes2(nums []int) {
	count := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			nums[count] = nums[i]
			count++
		}
	}
	for count < len(nums) {
		nums[count] = 0
		count++
	}
}

// 最优解
// 3. 双指针，快慢指针之间的值为0，快指针指向非0值，和慢指针交换值
// 时间复杂度 O(n), 空间复杂度O(1)
// 比第二种方法好在，遇到最坏情况只要一动一次 [0,0,0,0,0,1]
func moveZeroes3(nums []int) {
	count := 0
	for i, n := range nums {
		if n != 0 {
			nums[count], nums[i] = nums[i], nums[count]
			count++
		}
	}
}

//leetcode submit region begin(Prohibit modification and deletion)
func moveZeroes(nums []int) {
	count := 0
	for i, n := range nums {
		if n != 0 {
			nums[count], nums[i] = nums[i], nums[count]
			count++
		}
	}
}

//leetcode submit region end(Prohibit modification and deletion)
