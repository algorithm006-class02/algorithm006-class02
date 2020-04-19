package leetcode

func FirstUniqChar(s string) int {
	var help [26]int
	for _, c := range s {
		help[int(c-97)]++
	}
	for i, c := range s {
		if 1 == help[int(c-97)] {
			return i
		}
	}
	return -1
}
