package main

import "fmt"

func main() {
	data := []int{0,1,2,3,4,10}

	fmt.Println(twoSum(data, 10))

}


func twoSum(nums []int, target int) []int {

	count := len(nums)
	if count < 2 {
		return nil
	}

	// 使用hashMap来存储已便利过的index
	half := make(map[int]int, count)
	var result []int

	for i := 0; i < count; i++ {

		v, ok := half[nums[i]]
		if ok {
			result = append(result, v, i)
			break
		} else {
			half[target - nums[i]] = i
		}
	}

	return result
}
