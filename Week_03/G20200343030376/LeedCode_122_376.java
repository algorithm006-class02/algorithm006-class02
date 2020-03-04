package com.example.lib;

/**
 * 所属项目:JavaProject
 * 所属类名:com.example.lib.LeedCode_122_376
 * 功能描述:
 * 创建作者:VVs
 * 创建时间:2020/3/1
 */

public class LeedCode_122_376 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
        
    }

}
