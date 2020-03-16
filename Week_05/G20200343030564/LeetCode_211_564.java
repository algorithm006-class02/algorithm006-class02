package week05;

import java.util.Arrays;

/**
 * 最大正方形
 *
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class LeetCode_211_564 {

    public static void main(String[] args) {
        LeetCode_211_564 leetCode = new LeetCode_211_564();

        char[][] matrix = new char[5][5];
        Arrays.fill(matrix[0], '1');
        Arrays.fill(matrix[1], '1');
        Arrays.fill(matrix[2], '1');
        Arrays.fill(matrix[3], '1');
        Arrays.fill(matrix[4], '1');
        matrix[0][1] = '0';
        matrix[0][3] = '0';
        matrix[0][4] = '0';
        matrix[1][1] = '0';
        matrix[3][1] = '0';
        matrix[3][2] = '0';
        matrix[3][4] = '0';

        System.out.println(leetCode.maximalSquare(matrix));
        System.out.println(leetCode.maximalSquare1(matrix));
    }

    /**
     * 动态规划
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n)
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;
        for (int i = 1; i <= matrix.length ; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]),dp[i - 1][j]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }

        }
        return max * max;
    }

    /**
     * 动态规划  优化
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(n)
     *
     * @param matrix
     * @return
     */
    public int maximalSquare1(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] dp = new int[matrix[0].length + 1];
        int prev = 0;
        int max = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j < matrix[0].length + 1; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    max = Math.max(dp[j], max);
                }else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return max * max;
    }
}
