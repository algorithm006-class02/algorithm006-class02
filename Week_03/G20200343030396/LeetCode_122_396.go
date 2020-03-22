package main

func maxProfit(prices []int) int {
	sum := 0
	for i,_ := range prices {
		if i==0 {
			continue
		}
		if prices[i] > prices[i-1] {
			sum += prices[i] - prices[i-1]
		}
	}
	return sum
}