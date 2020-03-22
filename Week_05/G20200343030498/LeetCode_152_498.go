package main

func main() {

}

/*
思路
标签：动态规划
	1. 遍历数组时计算当前最大值，不断更新
	2. 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
	3. 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
	当负数出现时则imax与imin进行交换再进行下一步计算
	4. 时间复杂度：O(n)
*/
func maxProduct(nums []int) int {
	length := len(nums)
	if length < 1 {
		return 0
	}

	iMax, iMin, max := 1, 1, nums[0]
	for i := 0; i < length; i++ {

		if nums[i] < 0 {
			iMax, iMin = iMin, iMax
		}

		if nums[i] > nums[i] * iMax {
			iMax = nums[i]
		} else {
			iMax *= nums[i]
		}
		if nums[i] < nums[i] * iMin {
			iMin = nums[i]
		} else {
			iMin *= nums[i]
		}

		if iMax > max {
			max = iMax
		}
	}

	return max
}
