//给定一个没有重复数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法

package main

func main() {

}

//leetcode submit region begin(Prohibit modification and deletion)
func permute(nums []int) [][]int {
	n := len(nums)
	path := make([]int, 0, n)
	used := make([]bool, n)
	result := [][]int{}

	var dfs func(nums []int, pos int)
	dfs = func(nums []int, pos int) {
		if pos == n {
			tmp := make([]int, n)
			copy(tmp, path)
			result = append(result, tmp)
			return
		}

		for i := 0; i < n; i++ {
			if !used[i] {
				path = append(path, nums[i])
				used[i] = true

				dfs(nums, pos+1)
				used[i] = false

				path = path[:len(path)-1]
			}
		}
	}

	dfs(nums, 0)
	return result
}

//leetcode submit region end(Prohibit modification and deletion)
