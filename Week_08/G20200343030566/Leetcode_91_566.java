package com.sebar.test.leetcode.eight.pratice;

/**
 * @Author LG-QCY
 * @Date :2020/4/5 17:49
 */
public class Leetcode_91_566 {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            //
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
