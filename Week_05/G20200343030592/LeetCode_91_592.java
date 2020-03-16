package com.gsf.geekbang_demo.arithmetic.leetCode.week05;

/**
 * 91. 解码方法
 */
public class Demo91 {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[len] = 1;
        //最后一个不为零,则有一种
        dp[len - 1] = s.charAt(len - 1) != '0'? 1 : 0;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            else dp[i] = (Integer.valueOf(s.substring(i, i + 2)) <= 26)? dp[i + 1] + dp[i + 2] : dp[i + 1];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.err.println(new Demo91().numDecodings("12"));
    }
}

/**
 * 1、最优子结构  problem(i) = dp(i + 1) + dp(i + 2)
 * 2、状态定义   f(i)
 * 3、dp方程   f(i) = dp(i + 1) + dp(i + 2)
 */
