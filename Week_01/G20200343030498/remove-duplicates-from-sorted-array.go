package main

import (
	"fmt"
)

func main() {

	data := []int{0,0,1,1,1,2,2,3,3,4}

	fmt.Println(removeDuplicates(data))
}

func removeDuplicates(nums []int) int {
	count := len(nums)
	if count <= 1 {
		return count
	}

	nonRepeatedIndex := 0 //去重后的最小下标
	for i := 1; i < count; i++ {
		if nums[i] != nums[i-1] {
			nonRepeatedIndex++
			nums[nonRepeatedIndex] = nums[i]
		}
	}

	return nonRepeatedIndex + 1
}
