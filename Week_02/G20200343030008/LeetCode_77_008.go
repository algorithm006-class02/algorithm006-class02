//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法

package main

func main() {

}

/*
// 方法一
func combine(n int, k int) [][]int {
	result := make([][]int, 0)

	if n <= 0 || k <= 0 || n < k {
		return result
	}

	var backTrack func(first int, curr []int)
	backTrack = func(first int, curr []int) {
		if len(curr) == k {
			tmp := make([]int, k)
			copy(tmp, curr)
			result = append(result, tmp)
			return
		}
		for i := first; i <= n; i++ {
			curr = append(curr, i)
			backTrack(i+1, curr)
			curr = curr[:len(curr)-1]
		}
	}
	backTrack(1, []int{})
	return result
}
*/

//leetcode submit region begin(Prohibit modification and deletion)
func combine(n int, k int) [][]int {
	comb := make([]int, k)
	res := [][]int{}

	var dfs func(int, int)
	dfs = func(idx, begin int) {
		if idx == k {
			tmp := make([]int, k)
			copy(tmp, comb)
			res = append(res, tmp)
			return
		}

		for i := begin; i <= n+1-k+idx; i++ {
			comb[idx] = i
			dfs(idx+1, i+1)
		}
	}

	dfs(0, 1)

	return res
}

//leetcode submit region end(Prohibit modification and deletion)
