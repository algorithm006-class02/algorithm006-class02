package main

func main() {
	data := []int{0,1,0,3,12}

	moveZeroes(data)
}

func moveZeroes(nums []int)  {

	count := len(nums)
	if count < 2 {
		return
	}

	// 直观法 不为零就向前移
	targetIndex := 0
	for i := 0; i < count; i++ {

		if nums[i] != 0 {
			if targetIndex != i {
				nums[targetIndex] = nums[i]
				nums[i] = 0
			}

			targetIndex++
		}
	}
}