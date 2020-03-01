package main

import "sort"

func groupAnagrams(strs []string) [][]string {
	m := make(map[string][]string, 0)
	for i,s := range strs {
		key := sortStr(s)
		m[key] = append(m[key], strs[i])
	}
	result := make([][]string,0, len(m))
	for _,v := range m {
		result = append(result, v)
	}
	return result
}

type runeSlice []rune

func (l runeSlice) Len() int            { return len(l) }
func (l runeSlice) Swap(i, j int)      { l[i], l[j] = l[j], l[i] }
func (l runeSlice) Less(i, j int) bool { return l[i] < l[j] }

func sortStr(str string) string {
	rawRune := runeSlice(str)
	sort.Sort(rawRune)
	return string(rawRune)
}

