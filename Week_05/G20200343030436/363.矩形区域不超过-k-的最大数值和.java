/*
 * @lc app=leetcode.cn id=363 lang=java
 *
 * [363] 矩形区域不超过 K 的最大数值和
 */

// @lc code=start
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 0) {
            return 0;
        }
        if (cols == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < cols + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        for (int i1 = 0; i1 < rows; i1++) {
            for (int i2 = i1 + 1; i2 <= rows; i2++) {
                for (int j1 = 0; j1 < cols; j1++) {
                    for (int j2 = j1 + 1; j2 <= cols; j2++) {
                        int total = dp[i2][j2] - dp[i2][j1] - dp[i1][j2] + dp[i1][j1];
                        if (total == k) {
                            return total;
                        }
                        if (total < k) {
                            res = Math.max(total, res);
                        }
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

