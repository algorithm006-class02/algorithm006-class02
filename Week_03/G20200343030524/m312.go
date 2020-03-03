package xmaths

/*
 * @lc app=leetcode.cn id=122 lang=golang
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
func MaxProfit(prices []int) int {
	if len(prices) <= 1 {
		return 0
	}
	sum := 0
	min := prices[0]
	for _, v := range prices {
		if v <= min {
			min = v
			continue
		}
		sum += v - min
		min = v
	}
	return sum
}

// @lc code=end
