package com.test.datastructure;

public class MaxProfit122 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices==null || prices.length == 0 || prices.length == 1) {
            return profit;
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
