func generateParenthesis(n int) []string {
	if n == 0 {
		return []string{""}
	}

	result := []string{""}
	current := ""

	dfs(&result, current, n, n)
	return result[1:]
}

func dfs(result *[]string, current string, left int, right int) {
	if left == 0 && right == 0 {
		*result = append(*result, current)
		return
	}
	if right < left {
		return
	}
	if left > 0 {
		dfs(result, current+"(", left-1, right)
	}
	if right > 0 {
		dfs(result, current+")", left, right-1)
	}
}