package com.ping.leetcode.medium;

/**
 * @Author: 高一平
 * @Date: 2020/3/15
 * @Description: 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 **/
public class MaximalSquare221 {

    public int maximalSquare(char[][] matrix) {
        return maximalSquare1(matrix);
    }

    /**
     * @param matrix
     * @return
     */
    private int maximalSquare1(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] border = new int[rows + 1][cols + 1];
        int side = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    border[i][j] = Math.min(Math.min(border[i][j - 1], border[i - 1][j]), border[i - 1][j - 1]) + 1;
                    side = Math.max(side, border[i][j]);
                }
            }
        }
        return side * side;
    }

}
