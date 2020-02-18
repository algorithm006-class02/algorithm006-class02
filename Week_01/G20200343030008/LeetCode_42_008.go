//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针

package main

import (
	"fmt"
)

func main() {
	fmt.Println(trap([]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}))
}

// 计算每一行
/*
func trap(height []int) int {
	area := 0
	count := getMax(height)
	for i := 1; i <= count; i++ {
		begin := false
		tmp := 0
		for j := 0; j < len(height); j++ {
			if begin && height[j] < i {
				tmp++
			}
			if height[j] >= i {
				area += tmp
				tmp = 0
				begin = true
			}
		}
	}
	return area

}

func getMax(height []int) int {
	max := 0
	for _, n := range height {
		if n > max {
			max = n
		}
	}
	return max
}

*/

//leetcode submit region begin(Prohibit modification and deletion)

// 双指针法  按列求
func trap(height []int) int {
	var area int

	var i, j = 0, len(height) - 1
	var leftMax, rightMax = 0, 0
	for i < j {
		if height[i] < height[j] {
			if leftMax < height[i] {
				leftMax = height[i]
			} else {
				area += leftMax - height[i]
			}
			i++
		} else {
			if rightMax < height[j] {
				rightMax = height[j]
			} else {
				area += rightMax - height[j]
			}
			j--
		}
	}

	return area
}

//leetcode submit region end(Prohibit modification and deletion)
