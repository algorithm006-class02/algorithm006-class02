//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 示例:
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
// Related Topics 回溯算法

package main

func main() {

}

//leetcode submit region begin(Prohibit modification and deletion)
func solveNQueens(n int) [][]string {

	if n == 1 {
		return [][]string{{"Q"}}
	}
	if n <= 3 {
		return [][]string{}
	}
	var re [][]int

	shus, pies, nas := make(map[int]bool, n), make(map[int]bool, n), make(map[int]bool, n)
	DFS := func(rows []int, n int) {}
	DFS = func(rows []int, n int) {
		row := len(rows)
		if row == n {
			aaaa := make([]int, len(rows))
			copy(aaaa, rows)
			re = append(re, aaaa)
			return
		}

		for col := 0; col < n; col++ {
			if !shus[col] && !pies[row+col-1] && !nas[row-col-1] {
				shus[col] = true
				pies[row+col-1] = true
				nas[row-col-1] = true
				DFS(append(rows, col), n)
				shus[col] = false
				pies[row+col-1] = false
				nas[row-col-1] = false
			}
		}
	}

	DFS([]int{}, n)
	return bQ(re, n)
}

func bQ(re [][]int, n int) (result [][]string) {
	for _, v := range re {
		s := []string{}
		for _, vv := range v {
			str := ""
			for i := 0; i < n; i++ {
				if i == vv {
					str += "Q"
				} else {
					str += "."
				}
			}
			s = append(s, str)
		}
		result = append(result, s)
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
