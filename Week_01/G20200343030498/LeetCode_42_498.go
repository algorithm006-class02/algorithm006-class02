package main

func main() {
	//data := []int{0,1,0,2,1,0,1,3,2,1,2,1}

	data := []int{0,1,0,2,1,0,1,3,2,1,2,1}
	println(trap(data))

}

func trap(height []int) int {

	count := len(height)
	if count < 3 {
		return 0
	}

	ans := 0
	//leftMax, rightMax := 0 ,0

	// 1. 暴力法  O(n^2)
	//for i := 1 ; i < count-1 ; i++ {
	//
	//	leftMax, rightMax = 0 ,0
	//
	//	for j := i; j >=0; j-- {
	//		leftMax = getMax(height[j], leftMax)
	//	}
	//
	//	for j := i; j < count ; j++ {
	//		rightMax = getMax(height[j], rightMax)
	//	}
	//
	//	ans += getMin(leftMax, rightMax) - height[i]
	//}

	// 2. 循环 + DP O(n)
	//leftMaxSet, rightMaxSet := make([]int, count), make([]int, count)
	//leftMaxSet[0] = height[0]
	//for i := 1; i < count; i++ {
	//	if height[i] > leftMaxSet[i-1] {
	//		leftMaxSet[i] = height[i]
	//	} else {
	//		leftMaxSet[i] = leftMaxSet[i-1]
	//	}
	//}
	//
	//rightMaxSet[count-1] = height[count-1]
	//for i := count-2; i >= 0; i-- {
	//	if height[i] > rightMaxSet[i+1] {
	//		rightMaxSet[i] = height[i]
	//	} else {
	//		rightMaxSet[i] = rightMaxSet[i+1]
	//	}
	//}
	//
	//for i := 1; i < count; i++ {
	//	if leftMaxSet[i] > rightMaxSet[i] {
	//		ans += rightMaxSet[i] - height[i]
	//	} else {
	//		ans += leftMaxSet[i] - height[i]
	//	}
	//}

	// 3. 双指针 O(n)
	left, right := 0, count - 1
	leftMax, rightMax := height[left], height[right]
	//for left < right {
	//
	//	if height[left] < height[right] {
	//		if height[left] >= leftMax { //大于等于左最大值，update leftMax
	//			leftMax = height[left]
	//		} else {
	//			ans += leftMax - height[left]  //计算值
	//		}
	//
	//		left++ //向右移动
	//	} else {
	//		if height[right] >= rightMax {
	//			rightMax = height[right]
	//		} else {
	//			ans += rightMax - height[right]
	//		}
	//
	//		right-- //向左移动
	//	}
	//}

	// 双指针优化
	for left < right {

		if height[left] > leftMax {
			leftMax = height[left]
		}
		if height[right] > rightMax {
			rightMax = height[right]
		}

		if leftMax < rightMax {
			ans += leftMax - height[left]
			left++
		} else {
			ans += rightMax - height[right]
			right--
		}
	}

	return ans
}

func getMax(a, b int) int {

	if a >= b {
		return a
	}

	return b
}

func getMin(a, b int) int {

	if a <= b {
		return a
	}

	return b
}