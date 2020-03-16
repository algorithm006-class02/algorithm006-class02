package com.gsf.geekbang_demo.arithmetic.leetCode.week05;

/**
 * 221. 最大正方形
 */
public class Demo221 {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length, col = row > 0? matrix[0].length : 0;
        int[][] dp = new int[row + 1][col + 1];
        int max = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
