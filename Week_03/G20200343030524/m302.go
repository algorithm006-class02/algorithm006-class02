package xmaths

/*
 * @lc app=leetcode.cn id=17 lang=golang
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
func letterCombinations(digits string) []string {
	res := []string{}
	phone := map[string][]string{
		"2": {"a", "b", "c"},
		"3": {"d", "e", "f"},
		"4": {"g", "h", "i"},
		"5": {"j", "k", "l"},
		"6": {"m", "n", "o"},
		"7": {"p", "q", "r", "s"},
		"8": {"t", "u", "v"},
		"9": {"w", "x", "y", "z"}}
	for i := 0; i < len(digits); i++ {
		z := string(digits[i])
		// temp_arr := res
		if len(res) > 0 {
			temp_res := []string{}
			temp_res = append(temp_res, res...)
			for j := 0; j < len(phone[z]); j++ {
				for k, v := range temp_res {
					res = append(res[:j*len(temp_res)+k], v+phone[z][j])
				}
			}
		} else {
			res = append(res[:], phone[z]...)
		}
	} // 计算res总和
	return res
}

// @lc code=end
