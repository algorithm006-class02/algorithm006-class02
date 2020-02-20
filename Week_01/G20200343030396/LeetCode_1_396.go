package main

func twoSum(nums []int, target int) []int {
	numsMap := make(map[int]int);
	for i,v := range nums {
		if _,ok := numsMap[target-v]; ok {
			return []int{i, numsMap[target-v]}
		}
		numsMap[v] = i
	}
	return []int{}
}