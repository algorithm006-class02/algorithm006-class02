//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例:
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// Related Topics 回溯算法

package main

func main() {

}

//leetcode submit region begin(Prohibit modification and deletion)

// 笨办法，根据 46 题 改编
/*
func permuteUnique(nums []int) [][]int {
	n := len(nums)
	path := make([]int, 0, n)
	used := make([]bool, n)
	result := [][]int{}

	mHash := make(map[string]bool)

	var getKey func(nums []int) string
	getKey = func(nums []int) string {
		var str string
		for i := 0; i < len(nums); i++ {
			str += strconv.Itoa(nums[i])
		}
		return str
	}

	var dfs func(nums []int, pos int)
	dfs = func(nums []int, pos int) {
		if pos == n {
			tmp := make([]int, n)
			copy(tmp, path)
			k := getKey(tmp)
			if _, ok := mHash[k]; !ok {
				mHash[k] = true
				result = append(result, tmp)
			}
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

*/

func permuteUnique(nums []int) [][]int {
	var result [][]int
	var helper func(nums []int, i int)
	helper = func(nums []int, i int) {
		if i == len(nums) {
			// 如此复制，可以不使用 临时变量，减少内存分配
			result = append(result, make([]int, len(nums)))
			copy(result[len(result)-1], nums)
			return
		}

		mapVal := make(map[int]bool)
		for j := i; j < len(nums); j++ {
			if mapVal[nums[j]] {
				continue
			}
			nums[i], nums[j] = nums[j], nums[i]
			helper(nums, i+1)
			nums[i], nums[j] = nums[j], nums[i]
			mapVal[nums[j]] = true
		}
	}
	helper(nums, 0)
	return result
}

//leetcode submit region end(Prohibit modification and deletion)
