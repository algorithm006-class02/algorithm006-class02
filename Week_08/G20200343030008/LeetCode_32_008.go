//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
// 示例 1:
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//
//
// 示例 2:
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
//
// Related Topics 字符串 动态规划

package main

func main() {

}

//leetcode submit region begin(Prohibit modification and deletion)
func longestValidParentheses(s string) int {
	dp, res := make([]int, len(s)), 0
	// dp 数组表示 当前位置i处 之前在s串中构造的有效括号长度
	for i, _ := range s {
		if i > 0 && s[i] == ')' {
			if s[i-1] == '(' {
				if i == 1 {
					dp[i] = 2
				} else {
					dp[i] = dp[i-2] + 2
				}
			} else if s[i-1] == ')' && i-dp[i-1]-1 >= 0 && s[i-dp[i-1]-1] == '(' {
				if i-dp[i-1]-1 == 0 {
					dp[i] = dp[i-1] + 2
				} else {
					dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]
				}
			}
			if dp[i] > res {
				res = dp[i]
			}
		}
	}
	return res
}

//leetcode submit region end(Prohibit modification and deletion)
