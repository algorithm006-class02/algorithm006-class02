func maxProfit(prices []int) int {
	profit := 0
	for i := 1; i < len(prices); i++ {
		tmp := prices[i] - prices[i-1]
		if tmp > 0 {
			profit += tmp
		}
	}
	return profit
}
