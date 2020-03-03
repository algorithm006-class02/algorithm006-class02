package xmaths

/*
 * @lc app=leetcode.cn id=874 lang=golang
 *
 * [874] 模拟行走机器人
 */
// @lc code=start
type point struct {
    x, y int
}

func robotSim(commands []int, obstacles [][]int) int {
	dx := [4]int{0, 1, 0, -1}
    dy := [4]int{1, 0, -1, 0}
    set := make(map[point]bool)
    for _, v := range obstacles {
        set[point{v[0], v[1]}] = true
    }
    max := 0
    x := 0
    y := 0
    di := 0
    for _, c := range commands {
        if c == -1 {
            di = (di + 1) % 4
        } else if c == -2 {
            di = (di - 1 + 4) % 4
        } else {
            for i := 0; i < c; i++ {
                nx := x + dx[di]
                ny := y + dy[di]
                if set[point{nx, ny}] {
                    break
                } else {
                    x = nx
                    y = ny
                    if x*x + y*y > max {
                        max = x*x + y*y
                    }
                }
            }
        }
    }
    return max
}

// @lc code=end
