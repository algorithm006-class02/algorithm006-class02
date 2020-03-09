/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    
//     private int res;

    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        this.res = 0;
        dfs(prices, 0, len, 0, res);
        return this.res;
    }

    // prices 股价数组  index 当前从第几天 从0开始 status 估计0 持入 1卖出 profit当前股价的收益
    private void dfs(int[] prices, int index, int length, int status, int profits) {
//        终止条件 搜索到了数组的最后
        if (index == length) {
            this.res = Math.max(this.res, profits);
            return;
        }
        dfs(prices, index + 1, length, status, profits);
        if (status == 0) {
            //尝试转向 1  卖出 获利
            dfs(prices, index + 1, length, 1, profits - prices[index]);
        } else {
            //尝试转向0
            dfs(prices, index + 1, length, 0, profits + prices[index]);
        }
    }

    int res = 0;

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                res += diff;
            }
        }
        return this.res;
    }

//     201/201 cases passed (4 ms)
// Your runtime beats 8.09 % of java submissions
// Your memory usage beats 5.04 % of java submissions (42.9 MB)
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        //0持有 1持股
        //殊途同归 最终都是 0 1 0 1 0 最后是 0
        int[][] dp = new int[len][2];// 2是为了展示 0 1的状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
// @lc code=end

