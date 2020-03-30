func reverseBits(num uint32) uint32 {
	var bit, result uint32
	bit, result = 0, 0

	for i := 0; i < 32; i++ {
		bit = num & 1
		result = result | bit
		if i < 31 {
			num = num >> 1
			result = result << 1
		}
	}

	return result
}
