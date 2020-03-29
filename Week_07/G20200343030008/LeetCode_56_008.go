//给出一个区间的集合，请合并所有重叠的区间。
//
// 示例 1:
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
// Related Topics 排序 数组

package main

import "sort"

func main() {

}

//leetcode submit region begin(Prohibit modification and deletion)
func merge(intervals [][]int) [][]int {
	if len(intervals) == 0 || len(intervals) == 1 {
		return intervals
	}
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	ans := [][]int{}
	var max func(a int, b int) int
	max = func(a int, b int) int {
		if a > b {
			return a
		}
		return b
	}
	l := intervals[0][0]
	r := intervals[0][1]
	for i := 1; i < len(intervals); i++ {
		if r >= intervals[i][0] {
			r = max(intervals[i][1], r)
		} else if intervals[i][0] > r {
			ans = append(ans, []int{l, r})
			l = intervals[i][0]
			r = intervals[i][1]
		}
		// fmt.Printf("%d %d\n",l,r)
	}
	ans = append(ans, []int{l, r})
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
