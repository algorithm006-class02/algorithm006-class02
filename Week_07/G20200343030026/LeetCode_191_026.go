func hammingWeight(num uint32) int {
	result := 0

	for i := 0; i < 32; i++ {
		if num&1 == 1 {
			result++
		}
		num = num >> 1
	}

	return result
}
