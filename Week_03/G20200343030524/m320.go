package xmaths

/*
 * @lc app=leetcode.cn id=74 lang=golang
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) == 0 {
		return false
	}

	start := 0
	end := len(matrix)
	for start < end {
		mid := (start + end) / 2

		if len(matrix[mid]) == 0 {
			return searchMatrix(matrix[:mid], target) || searchMatrix(matrix[mid+1:], target)
		}

		curBegin := matrix[mid][0]
		var nextBegin int
		if mid+1 >= len(matrix) {
			nextBegin = matrix[mid][len(matrix[mid])-1] + 1
		} else {
			nextBegin = matrix[mid+1][0]
		}

		if target >= curBegin && target < nextBegin {
			return searchRow(matrix[mid], target)
		}

		if target < curBegin {
			end = mid
		} else {
			start = mid + 1
		}
	}

	return false
}

func searchRow(row []int, target int) bool {
	if len(row) == 0 {
		return false
	}

	start := 0
	end := len(row)
	for start < end {
		mid := (start + end) / 2
		v := row[mid]
		switch {
		case target == v:
			return true
		case target < v:
			end = mid
		case target > v:
			start = mid + 1
		}
	}
	return false
}

// @lc code=end
