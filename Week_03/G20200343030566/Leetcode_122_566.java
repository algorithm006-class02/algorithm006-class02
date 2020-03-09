package com.sebar.test.leetcode.three.practice.greedy;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class Leetcode_122_566 {
    /**
     * 贪心算法计算最佳时机
     * 只要当前位置的下一个位置比当前位置大，则当前位置买进，下一个位置卖出
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        Integer maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit = maxProfit + (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }

    /**
     * 波峰与波谷的解法
     *
     * @param prices
     * @return
     */
    public int peakVally(int[] prices) {
        int maxProfit = 0;
        int i = 0;
        // 初始化波谷
        int vally = prices[0];
        // 初始化波峰
        int peak = prices[0];

        while (i < prices.length - 1) {
            while (prices[i] >= prices[i + 1]) {
                i++;
            }
            vally = prices[i];

            while (prices[i] < prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxProfit += peak - vally;
        }
        return maxProfit;
    }
}
