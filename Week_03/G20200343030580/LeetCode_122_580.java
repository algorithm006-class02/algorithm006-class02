class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            maxProfit += prices[i + 1] > prices[i] ? prices[i + 1] - prices[i] : 0;
        }
        return maxProfit;
    }
}