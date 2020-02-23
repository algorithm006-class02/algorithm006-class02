package main

import (
	"fmt"
	"sort"
)

//字符串排序
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

func main() {

	//data := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	data := []string{"", "", "eat"}

	fmt.Println(groupAnagrams(data))

}

func groupAnagrams(strs []string) [][]string {

	count := len(strs)
	if count == 0 {
		return [][]string{}
	}
	if count == 1 {
		return [][]string{strs}
	}

	result := make([][]string, 0, count)

	//循环 + 排序 + hashMap
	//1. 对每个元素进行排序，把排序好的字符串作为hashMap的key，该key对应的值为所有排序后都为key的元素
	//2. 把hashMap 转换成 slice
	var key string
	cacheMap := make(map[string][]string, count)
	for _, str := range strs {
		key = SortString(str)
		cacheMap[key] = append(cacheMap[key], str)
	}

	//map转化成slice
	for _, v := range cacheMap {
		result = append(result, v)
	}

	return result
}

