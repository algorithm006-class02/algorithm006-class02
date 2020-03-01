package week3;

/**
 * 122. 买卖股票的最佳时机 II
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class BuyCellStock {
    public static void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("最大利润：" + new BuyCellStock().maxProfit2(prices));
    }

    public int maxProfit(int[] prices) {
        // 贪心法：只买涨不买跌
        // 同九年，汝何秀 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/best-time-to-buy-and
        // -sell-stock-ii-zhuan-hua-fa-ji/
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int delta = prices[i] - prices[i - 1];
            if (delta > 0) {
                maxProfit += delta;
            }
        }
        return maxProfit;
    }

    // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
    public int maxProfit2(int[] prices) {
        // 峰谷法-连续的峰和谷
        // 波谷与它紧临的波峰，之前的差值即是这段时间内的最大利润
        int maxProfit = 0;

        int i = 0;
        while (i < prices.length - 1) {
            int peak = 0, valley = 0;
            // 找波谷
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            valley = prices[i];

            // 找波峰
            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            peak = prices[i];

            maxProfit += peak - valley;
        }
        return maxProfit;
    }
}
