class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        for index in range(len(prices) - 1):
            if prices[index+1] > prices[index]:
                res += (prices[index+1] - prices[index])
        return res
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        for index in range(len(prices) - 1):
            if prices[index+1] > prices[index]:
                res += (prices[index+1] - prices[index])
        return res