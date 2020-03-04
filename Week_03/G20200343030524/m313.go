package xmaths

import "sort"

/*
 * @lc app=leetcode.cn id=455 lang=golang
 *
 * [455] 分发饼干
 */

// @lc code=start
func FindContentChildren(g []int, s []int) int {
	if len(g) == 0 || len(s) == 0 {
		return 0
	}
	sort.Ints(g)
	sort.Ints(s)
	maxNum := 0
	i := 0
	for _, v := range s {
		if i < len(g) {
			if v >= g[i] {
				maxNum++
				i++
			}
		}
	}
	return maxNum

}

// @lc code=end
