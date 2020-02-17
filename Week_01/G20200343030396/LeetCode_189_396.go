package main

func rotate(nums []int, k int)  {
	k%=len(nums)
	reverse(nums, 0, len(nums)-1)
	reverse(nums, 0, k)
	reverse(nums, k, len(nums)-1)
}

func reverse(nums []int, start int, end int) {
	if len(nums) <= end {
		end = len(nums)-1
	}
	for  ;start<end; {
		temp:=nums[start]
		nums[start]=nums[end]
		nums[end]=temp

		start++
		end--
	}
}


