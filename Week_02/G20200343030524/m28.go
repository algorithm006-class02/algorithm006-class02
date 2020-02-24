package xmaths

/*
 * @lc app=leetcode.cn id=77 lang=golang
 *
 * [77] 组合
 */

// @lc code=start
func combine(n int, k int) [][]int {
	if k>n {
		return nil
	}
	res := [][]int{}
	if n==0 {
		return [][]int{{}}
	}
	var arr = make([]int, n)
    for i := range arr {
        arr[i] = i + 1
    }
    backCombine(&res, arr, 0, k)
    return res
}
func backCombine(result *[][]int, nums []int, index, k int) {
    //达到目的，进行回溯
    if index == k {
        *result = append(*result, append([]int{}, nums[0:k]...))
        return
    }
    for start := index; start < len(nums); start ++ {
        //可以在这里进行剪枝。去除递减的序列，防止结果重复
        if index == 0 || nums[start] > nums[index -1] {
            nums[start], nums[index] = nums[index], nums[start]
            backCombine(result, nums, index + 1, k)
            nums[index], nums[start] = nums[start], nums[index]
        }   
    }
    return 

}

// @lc code=end