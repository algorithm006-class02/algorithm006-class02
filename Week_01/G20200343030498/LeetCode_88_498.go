package main

func main() {

	data1 := []int{1, 2 ,3, 4, 0}
	data2 := []int{1}

	merge(data1, 4, data2, 1)
}

func merge(nums1 []int, m int, nums2 []int, n int)  {

	if m == 0 {
		for i := 0; i < n; i++ {
			nums1[i] = nums2[i]
		}
		return
	}

	if n == 0 {
		return
	}

	//1 从前往后合并 + 申请内存
	//nums1Copy := make([]int, m)
	//_ = copy(nums1Copy, nums1[:m])
	//nums1Index, nums2Index := 0, 0
	//
	//for i := 0; i < (m + n); i++ {
	//
	//	if nums1Index > m - 1{
	//		nums1[i] = nums2[nums2Index]
	//		nums2Index++
	//		continue
	//	}
	//
	//	if nums2Index > n - 1 {
	//		nums1[i] = nums1Copy[nums1Index]
	//		nums1Index++
	//		continue
	//	}
	//
	//	if nums1Copy[nums1Index] < nums2[nums2Index] {
	//		nums1[i] = nums1Copy[nums1Index]
	//		nums1Index++
	//	} else {
	//		nums1[i] = nums2[nums2Index]
	//		nums2Index++
	//	}
	//}

	//2 从后往前合并
	nums1Index, nums2Index := m - 1, n - 1
	for i := m + n - 1; i >= 0; i-- {

		if nums1Index < 0 {
			nums1[i] = nums2[nums2Index]
			nums2Index--
			continue
		}

		if nums2Index < 0 {
			nums1[i] = nums1[nums1Index]
			nums1Index--
			continue
		}

		if nums1[nums1Index] > nums2[nums2Index] {
			nums1[i] = nums1[nums1Index]
			nums1Index--
		} else {
			nums1[i] = nums2[nums2Index]
			nums2Index--
		}
	}

}