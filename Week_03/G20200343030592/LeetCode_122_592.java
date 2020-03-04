package com.gsf.geekbang_demo.arithmetic.leetCode.week03;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class Demo122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length <= 1) return 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }
}
