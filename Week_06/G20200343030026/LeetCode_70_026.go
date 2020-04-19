func climbStairs(n int) int {
	n0, n1 := 0, 1

	for i := 0; i < n; i++ {
		n0, n1 = n1, n0+n1
	}

	return n1
}
