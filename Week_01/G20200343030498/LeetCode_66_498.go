package main

import "fmt"

func main() {
	data := []int{8,9,9}
	fmt.Println(plusOne(data))
}

func plusOne(digits []int) []int {

	//思路. 低位+1 == 10 向高位加1，当遇到最高位溢出时，重新申请空间并把第一位置为0

	for i := len(digits) - 1; i >= 0; i-- {
		//digits[i] += 1
		//if digits[i] < 10 {
		//	return digits
		//}
		if digits[i] < 9 {
			digits[i]++
			return digits
		}

		digits[i] = 0
	}

	//最高位溢出
	digits = append([]int{1}, digits...)

	return digits
}