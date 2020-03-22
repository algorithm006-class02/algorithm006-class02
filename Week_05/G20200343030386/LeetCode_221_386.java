package com.example.leetCode.week5;


public class LeetCode_221_386 {
//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
// 示例:
//
// 输入:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4
// Related Topics 动态规划

    public int maximalSquare(char[][] matrix) {
        // 最小子问题
        // 每一个f(i)(j) = Math.min(f(i)(j - 1), f(i - 1)(j), f(i - 1)(j - 1)) + char[i][j]

        // 状态存储结构（含义代表什么）
        // 每一个dp[i][j] 代表能连通的正方形的边长

        // 状态转移方程
        // dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j]

        // 二维转一维用变量替换即可

        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col + 1];
        int maxsize = 0;
        int prev = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                int tmp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), prev) + 1;
                    maxsize = Math.max(maxsize, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = tmp;
            }
        }
        return maxsize * maxsize;
    }

}
