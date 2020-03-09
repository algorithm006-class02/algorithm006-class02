class Solution(object):
    def maxProfit(self, prices):
        #贪心，相当于把每天的利润都收入囊中
        profit = 0 
        for i in range(1, len(prices)):
            tmp = prices[i] - prices[i - 1]
            if tmp > 0: 
                profit += tmp
        return profit