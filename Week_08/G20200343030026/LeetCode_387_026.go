func firstUniqChar(s string) int {
	alpha := make([]int, 26)

	for _, c := range s {
		alpha[c-'a']++
	}

	for i := 0; i < len(s); i++ {
		if alpha[s[i]-'a'] == 1 {
			return i
		}
	}

	return -1
}