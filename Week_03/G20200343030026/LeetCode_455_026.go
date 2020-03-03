func findContentChildren(g []int, s []int) int {
	var ans int

	sort.Ints(g)
	sort.Ints(s)

	glength := len(g)
	slength := len(s)

	i, j := 0, 0
	for i < glength && j < slength {
		if g[i] <= s[j] {
			i++
			j++
			ans++
		} else {
			j++
		}
	}

	return ans
}
