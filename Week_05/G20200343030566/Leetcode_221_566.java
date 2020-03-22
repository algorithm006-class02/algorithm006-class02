package com.sebar.test.leetcode.five.homework;

/**
 * https://leetcode-cn.com/problems/maximal-square/
 * 221. 最大正方形
 */
public class Leetcode_221_566 {
    /**
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix){
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxSqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxSqlen = Math.max(maxSqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxSqlen * maxSqlen;
    }
}
