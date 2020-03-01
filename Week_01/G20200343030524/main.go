package main

import (
	"fmt"
	"xmath/xmaths"
	_ "xmath/xmaths"
)

func main() {
	// fmt.Printf("hello, world!")
	// 结果1
	// testarray := []int{0, 1, 0, 3, 12}
	// xmaths.MoveZeroes(testarray)

	// 结果2
	// nums := []int{3, 3, 11, 15}
	// newnums := []int{}
	// target := 6
	// newnums = xmaths.Twosum(nums, target)
	// fmt.Println(newnums)

	// 结果3
	// nums1 := []int{1, 3, 7, 12, 5, 9}
	// nums2 := []int{1, 22, 33, 56, 15, 19, 44, 37, 108, 99}
	// newnumber := xmaths.FindMedianSortedArrays(nums1, nums2)
	// fmt.Println(newnumber)

	// 结果4
	// nums1 := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	// num := xmaths.MaxArea(nums1)
	// fmt.Println(num)

	// 结果5
	// testarray := []int{1, 1, 1}
	// num := xmaths.RemoveDuplicates(testarray)
	// fmt.Println(num)

	// 结果6
	// testarray := []int{1, 2, 3, 4, 5, 6, 7}
	// key := 3
	// xmaths.Rotate(testarray, key)

	// 结果7

	// 结果8
	// linkedList1 := xmaths.New()
	// linkedList1.Insert(1, 5)
	// linkedList1.Insert(1, 4)
	// linkedList1.Insert(1, 2)
	// linkedList1.Insert(1, 1)

	// linkedList2 := xmaths.New()
	// linkedList2.Insert(1, 4)
	// linkedList2.Insert(1, 3)
	// linkedList2.Insert(1, 1)

	// linkedList3 := xmaths.New()
	// linkedList3 = xmaths.MergeTwoLists(linkedList1, linkedList2)
	// linkedList3.Traverse()

	// 结果9
	// arr1 := []int{1, 2, 3, 4, 5, 6, 5, 6}
	// arr2 := []int{6, 7, 8}

	// xmaths.Merge(arr1, 4, arr2, 3)

	// 结果10
	// arr1 := []int{1, 2, 3, 4}
	// res := xmaths.PlusOne(arr1)
	// fmt.Println(res)

	// 结果11
	arr1 := []int{2, 0, 2}
	fmt.Println(xmaths.Trap(arr1))

}
