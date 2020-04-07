func numDecodings(s string) int {
	if s[0] == '0' {
		return 0
	}

	pre, cur, length := 1, 1, len(s)
	for i := 1; i < length; i++ {
		tmp := cur
		if s[i] == '0' {
			if s[i-1] == '1' || s[i-1] == '2' {
				cur = pre
			} else {
				return 0
			}
		} else if s[i-1] == '1' || (s[i-1] == '2' && s[i] >= '1' && s[i] <= '6') {
			cur += pre
		}
		pre = tmp
	}

	return cur
}