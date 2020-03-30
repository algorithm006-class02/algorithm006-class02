func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	if len(s) == 0 && len(t) == 0 {
		return true
	}

	length := len(s)
	var result [26]int
	for i := 0; i < length; i++ {
		result[s[i]-'a']++
		result[t[i]-'a']--
	}

	for i := 0; i < 26; i++ {
		if result[i] != 0 {
			return false
		}
	}

	return true
}
