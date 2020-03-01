package xmaths

/*
 * @lc app=leetcode.cn id=200 lang=golang
 *
 * [200] 岛屿数量
 */

// @lc code=start
func numIslands(grid [][]byte) int {

	color := 1
	colors := make([][]int, len(grid))
	for x := range colors {
		colors[x] = make([]int, len(grid[x]))
	}

	for x := range grid {
		for y := range grid[x] {
			marked := markColor(x, y, grid, colors, color)
			if marked {
				color++
			}
		}
	}

	return color - 1
}
func markColor(x, y int, grid [][]byte, colors [][]int, color int) bool {
	if x < 0 || x >= len(grid) {
		return false
	}

	if y < 0 || y >= len(grid[x]) {
		return false
	}

	if colors[x][y] != 0 {
		return false
	}

	if grid[x][y] == '0' {
		colors[x][y] = -1
		return false
	}

	colors[x][y] = color
	markColor(x+1, y, grid, colors, color)
	markColor(x-1, y, grid, colors, color)
	markColor(x, y-1, grid, colors, color)
	markColor(x, y+1, grid, colors, color)
	return true
}

// @lc code=end

/*
 * @lc app=leetcode.cn id=200 lang=golang
 *
 * [200] 岛屿数量
 */

// @lc code=start
func numIslands2(grid [][]byte) int {
	// ditu_x := len(grid[0])
	// ditu_y := len(grid)
	// num, x, y := 0
	// for x < ditu_x && y < ditu_y {
	// 	if grid[x] {

	// 	}
	// 	x++
	// 	y++
	// }
	return 1

}

// @lc code=end
