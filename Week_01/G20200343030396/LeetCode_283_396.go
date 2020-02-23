package main

func moveZeroes(nums []int)  {
	for curr, lastNonZeroFoundAt:=0,0; curr<len(nums); curr++ {
		if nums[curr] != 0 {
			temp := nums[lastNonZeroFoundAt]
			nums[lastNonZeroFoundAt] = nums[curr]
			nums[curr] = temp;
			lastNonZeroFoundAt++
		}
	}
}
