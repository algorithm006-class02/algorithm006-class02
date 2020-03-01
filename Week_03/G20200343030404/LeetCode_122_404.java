class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null) {
            return 0;
        }
        int diff = 0;
        int result = 0;
        for(int i = 1 ; i < prices.length ; i ++) {
            diff = prices[i] - prices[i - 1];
            if(diff > 0) {
                result += diff;
            }
        }
        return result;
    }
}