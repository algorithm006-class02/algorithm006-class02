//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串

package main

import "sort"

func main() {

}

/*

func groupAnagrams(strs []string) [][]string {
	hMap := make(map[string][]string)
	for _, str := range strs {
		key := SortString(str)
		if v, ok := hMap[key]; !ok {
			hMap[key] = []string{str}
		} else {
			hMap[key] = append(v, str)
		}
	}
	ans := make([][]string, 0, 3)
	for _, v := range hMap {
		ans = append(ans, v)
	}
	return ans
}

type sortRunes []rune

func (s sortRunes) Less(i, j int) bool {
	return s[i] < s[j]
}

func (s sortRunes) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

func (s sortRunes) Len() int {
	return len(s)
}

func SortString(s string) string {
	r := []rune(s)
	sort.Sort(sortRunes(r))
	return string(r)
}

// slice 排序
func groupAnagrams(strs []string) [][]string {
	hMap := make(map[string][]string)
	for _, str := range strs {
		tmp := []byte(str)
		sort.Slice(tmp, func(i, j int) bool {
			return tmp[i] < tmp[j]
		})
		key := string(tmp)
		if v, ok := hMap[key]; !ok {
			hMap[key] = []string{str}
		} else {
			hMap[key] = append(v, str)
		}
	}
	ans := make([][]string, 0, 3)
	for _, v := range hMap {
		ans = append(ans, v)
	}
	return ans
}

*/

//leetcode submit region begin(Prohibit modification and deletion)
func groupAnagrams(strs []string) [][]string {
	hMap := make(map[string][]string)
	for _, str := range strs {
		tmp := []byte(str)
		sort.Slice(tmp, func(i, j int) bool {
			return tmp[i] < tmp[j]
		})
		key := string(tmp)
		if v, ok := hMap[key]; !ok {
			hMap[key] = []string{str}
		} else {
			hMap[key] = append(v, str)
		}
	}
	ans := make([][]string, 0, 3)
	for _, v := range hMap {
		ans = append(ans, v)
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
