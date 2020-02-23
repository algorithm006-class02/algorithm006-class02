package xmaths

/*
 * @lc app=leetcode.cn id=47 lang=golang
 *
 * [47] 全排列 II
 */

// @lc code=start
func PermuteUnique(nums []int) [][]int {
	// len_num := len(nums)
	// res := [][]int{}
	// res_str := []string{}
	// is_reload := 0
	// //
	// for i := 0; i < len_num; i++ {
	// 	for k := 0; k < len_num; k++ {
	// 	temp_res := append(nums[len_num-i-k:], nums[:len_num-i-k]...)
	// 	temp_str := strings.Trim(fmt.Sprint(temp_res), "[]")
	// 	is_reload = 0
	// 	for j := 0; j < len(res_str); j++ {
	// 		if res_str[j] == temp_str {
	// 			is_reload = 1
	// 		}
	// 	}
	// 	if is_reload == 0 {
	// 		res = append(res[:i][:], temp_res)
	// 		res_str = append(res_str[:], temp_str)
	// 	}

	// 	}
	// 	// fmt.Println(temp_str)
	// 	// res = append(res[:i][:], temp_res)
	// }
	// return res

	// res := [][]int{}
	// // 循环有多少个不一样的数字
	// diff_num := 0
	// // 将数字组合
	// new_nums := []int{}
	// is_cf := 0
	// for i := 0; i < len(nums); i++ {
	// 	is_cf = 0
	// 	for j := 0; j < len(new_nums); j++ {
	// 		if nums[i] == new_nums[j] {
	// 			is_cf = 1
	// 		}
	// 	}
	// 	if is_cf == 0 {
	// 		new_nums = append(new_nums[:], nums[i])
	// 		diff_num++
	// 	}
	// }

	// fmt.Println(diff_num)

	// return res
	res := [][]int{}
	backtrace(0, nums, &res)
	return res

}

func backtrace(first int, nums []int, res *[][]int) {
	if first == len(nums) {
		temp := make([]int, len(nums))
		copy(temp, nums)
		*res = append(*res, temp)
	}
	m := map[int]bool{}
	for i := first; i < len(nums); i++ {
		if m[nums[i]] {
			continue
		}
		m[nums[i]] = true
		nums[first], nums[i] = nums[i], nums[first]
		backtrace(first+1, nums, res)
		nums[first], nums[i] = nums[i], nums[first]
	}
}

// @lc code=end
