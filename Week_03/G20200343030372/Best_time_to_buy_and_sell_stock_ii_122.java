package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/2/27
 */
public class Best_time_to_buy_and_sell_stock_ii_122 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int maxSum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxSum += prices[i] - prices[i - 1];
            }
        }
        return maxSum;
    }
}
