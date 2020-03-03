/**
 * Created by HuGuodong on 2/29/20.
 */
public class LeetCode_122_364 {

  class Solution {

    public int maxProfit(int[] prices) {
      if (prices.length == 0) return 0;
      int res = 0;
      for (int i = 1; i < prices.length; i++) {
        int profit = prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        res += profit;
      }
      return res;
    }
  }
}
