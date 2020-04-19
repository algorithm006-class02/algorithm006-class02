package leetcode

import "sort"

// func Merge(intervals [][]int) [][]int {
// 	var ans [][]int = make([][]int, 0)
// 	var count int = 0
// 	for _, value := range intervals {
// 		var find bool = false
// 		for i := 0; i < count; i++ {
// 			var des []int = ans[i]
// 			if (value[0] <= des[0]) && (value[1] >= des[0]) {
// 				des[0] = value[0]
// 				if des[1] < value[1] {
// 					des[1] = value[1]
// 				}
// 				find = true
// 				break
// 			} else if (value[0] <= des[1]) && (value[1] >= des[1]) {
// 				des[1] = value[1]
// 				if des[0] > value[0] {
// 					des[0] = value[0]
// 				}
// 				find = true
// 				break
// 			} else if (value[0] >= des[0]) && (value[1] <= des[1]) {
// 				find = true
// 				break
// 			}
// 		}
// 		if !find {
// 			ans = append(ans, []int{value[0], value[1]})
// 			count++
// 		}
// 	}
// 	return ans
// }

func Merge(intervals [][]int) [][]int {
	if len(intervals) == 0 {
		return [][]int{}
	}
	merged := make([][]int, 0, len(intervals))
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	current := intervals[0]
	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] > current[1] {
			merged = append(merged, current)
			current = intervals[i]
		} else if intervals[i][1] > current[1] {
			current[1] = intervals[i][1]
		}
	}
	merged = append(merged, current)
	return merged
}
