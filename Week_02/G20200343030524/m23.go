package xmaths

import (
	"sort"
	"strings"
)

/*
 * @lc app=leetcode.cn id=49 lang=golang
 *
 * [49] 字母异位词分组
 */

// @lc code=start
func GroupAnagrams(strs []string) [][]string {
	var res [][]string
	if len(strs) == 0 {
		return res
	}
	var resMap = make(map[string][]string)
	for i := 0; i < len(strs); i++ {
		var curStrArr = strings.Split(strs[i], "")
		sort.Strings(curStrArr)
		var curStrIndex = strings.Join(curStrArr, "")
		resMap[curStrIndex] = append(resMap[curStrIndex], strs[i])
	}
	for _, value := range resMap {
		res = append(res, value)
	}
	return res
}

// @lc code=end

/*
------分割线------
------分割线------
------分割线------
*/
