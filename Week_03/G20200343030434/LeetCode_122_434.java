package algorithm.leetCode.week03.No122;

/**
 * @author ltw
 * on 2020-03-03.
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) //只要上升趋势 都持仓
                maxprofit += (prices[i] - prices[i - 1]);
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] x = {1, 7, 2, 3, 6, 7, 6};
        System.out.println(solution.maxProfit(x));
    }
}


