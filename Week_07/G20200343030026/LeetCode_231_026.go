func isPowerOfTwo(n int) bool {
	times := 0

	if n <= 0 {
		return false
	}

	for i := 0; i < 31; i++ {
		if times > 1 {
			return false
		}
		if n&1 == 1 {
			times++
		}
		n = n >> 1
	}

	if times > 1 {
		return false
	} else {
		return true
	}
}
