func plusOne(digits []int) []int {
	length := len(digits)

	for i := length - 1; i >= 0; i-- {
		if digits[i] < 9 {
			digits[i]++
			return digits
		} else {
			digits[i] = 0
		}
	}

	result := make([]int, length+1)
	result[0] = 1

	return result
}
