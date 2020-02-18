package main

func plusOne(digits []int) []int {
	i := len(digits)-1
	if digits[i] < 9 {
		digits[i] += 1
	} else {
		digits[i] = 10
		for ; digits[i]==10; i-- {
			digits[i] = 0
			if i == 0 {
				newArray := append([]int{}, 1,)
				digits = append(newArray, digits...)
				return digits
			}
			if i!=0 {
				digits[i-1]+=1
			}
		}
	}
	return digits
}
