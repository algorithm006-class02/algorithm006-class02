class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minprice, maxprofit = int(1e9), 0
        for price in prices:
            maxprofit = max(price - minprice, maxprofit)
            minprice = min(price, minprice)
        return maxprofit