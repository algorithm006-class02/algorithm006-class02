/**
 * 64. 最小路径和
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for(int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for(int j = 1; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[dp.length - 1];
    }
}