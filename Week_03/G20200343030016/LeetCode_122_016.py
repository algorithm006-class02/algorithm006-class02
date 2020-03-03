# =====================================
# No.122 买卖股票的最佳时机 II
# 解题思路：贪心算法
# 如果明天的股价大于今天的股价就今天买进，明天卖出。否则，不交易
# =====================================


class Solution(object):
    def maxProfit(self, prices):
        max_profit = 0
        for i in range(len(prices)-1):
            if (prices[i+1] - prices[i]) > 0:
                max_profit = max_profit+(prices[i+1] - prices[i])
        return max_profit


if __name__ == '__main__':
    solution = Solution()
    test_1 = [7, 1, 5, 3, 6, 4]
    test_2 = [1, 2, 3, 4, 5]
    test_3 = [7, 6, 4, 3, 1]
    print(solution.maxProfit(test_1))
    print(solution.maxProfit(test_2))
    print(solution.maxProfit(test_3))
