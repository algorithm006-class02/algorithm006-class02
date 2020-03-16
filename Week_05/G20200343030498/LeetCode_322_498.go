package main

import (
	"fmt"
	"math"
)

func main() {
	data := []int{1, 2, 5}

	fmt.Println(coinChange(data, 100))
}

func coinChange(coins []int, amount int) int {

	ans := math.MaxInt64

	helper(coins, amount, 0, &ans)

	if ans == math.MaxInt64 {
		return -1
	}

	return ans
}

//递归 超时
func helper(coins []int, current, lvl int, result *int) {
	fmt.Println(current, lvl, *result)

	//recursion terminator
	if current < 0 {
		return
	} else if current == 0 {
		if lvl < *result {
			*result = lvl
		}
		return
	}

	//drill down and current logic
	for _, v := range coins {
		k := current / v //增加贪心
		for k > 0 && lvl + k < *result {

			helper(coins, current - v * k, lvl + k, result)
			k--
		}
	}
}

//dp
//func coinChange(coins []int, amount int) int {
//	if amount == 0 {
//		return 0
//	}
//
//	dp := make(map[int]int, amount + 1)
//	dp[0] = 0
//
//	// dp[i] = min(dp[i-1], dp[i-2], dp[i-5]) + 1
//	for i := 1; i <= amount; i++ {
//		dp[i] = amount + 1 //初始化为最大值
//		for _, v := range coins {
//			if v <= i && dp[i-v] + 1 < dp[i] {
//				dp[i] = dp[i-v] + 1
//			}
//		}
//	}
//
//	if dp[amount] > amount {
//		return -1
//	}
//
//	return dp[amount]
//}

//bfs
//func coinChange(coins []int, amount int) int {
//	if amount == 0 {
//		return 0
//	}
//
//	ans := -1
//
//	queue := coins
//	slaveQueue := []int{}
//	visited := make(map[int]bool)
//	for _, v := range coins {
//		visited[v] = true
//	}
//
//	lvl := 1
//	for len(queue) > 0 {
//		//取头部
//		top := queue[0]
//		queue = queue[1:]
//
//		if top == amount {
//			return lvl
//		}
//
//		for _, v := range coins {
//			flag, _ := visited[top+v]
//			if flag !+ true && top + v <= amount { //小于
//				visited[top + v] = true
//				slaveQueue = append(slaveQueue, top + v)
//			}
//		}
//
//		if len(queue) == 0 {
//			queue = slaveQueue
//			slaveQueue = []int{}
//			lvl++
//		}
//	}
//
//	return ans
//}