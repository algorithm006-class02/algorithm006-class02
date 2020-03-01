class Solution {
    public int maxProfit(int[] prices) {
        //设置利益
        int profit;
        for (int i = 1; i < prices.length; i++) {
            int tmp = profit[i] - profit[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }
}

//暴力搜索
class Solution {
    private int res;

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;//只有一天
        this.res = 0;
        dfs(prices, 0, len, 0, res);
        return this.res;
    }

    private void dfs(int[] price, int index, int len, int status, int profit) {
        if (index == len) {
            this.res = Math.max(this.res, profit);
            return;
        }
        dfs(price, index + 1, len, status, profit);
        //计算买卖
        if (status == 0) dfs(price, index + 1, len, 1, profit - price[index]);
        else dfs(price, index + 1, len, 0, profit + price[index]);
    }

}

//动态规划
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][10]
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) total += prices[i + 1] - prices[i];
        }
        return total;
    }
}