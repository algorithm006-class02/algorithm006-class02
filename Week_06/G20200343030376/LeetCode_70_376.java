package com.example.lib;

/**
 * 所属项目:JavaProject
 * 所属类名:com.example.lib.LeetCode_70_376
 * 功能描述:
 * 创建作者:VVs
 * 创建时间:2020/3/22
 */

public class LeetCode_70_376 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
