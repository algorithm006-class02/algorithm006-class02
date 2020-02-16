package main

func main() {
	data := []int{1,2,3,4,10}

	rotate(data, 2)
}


func rotate(nums []int, k int)  {

	count := len(nums)
	if count < 2 || k < 1 {
		return
	}
	k %= count
	if k == 0 {
		return
	}

	//1. 申请单独内存存储
	//tmpCopy := make([]int, count)
	//_ = copy(tmpCopy, nums)
	//
	//for i := 0; i < count; i++ {
	//
	//	nums[(i + k) % count] = tmpCopy[i]
	//}


	//2. 反转3次
	//这个方法基于这个事实：当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
	reverse(nums)
	reverse(nums[:k])
	reverse(nums[k:])

}

func reverse(nums []int) {

	for i, j := 0, len(nums) - 1; i < j; i, j = i+1, j-1 {
		nums[i], nums[j] = nums[j], nums[i]
	}
}
