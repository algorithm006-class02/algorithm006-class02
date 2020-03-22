/**
 * 63. 不同路径2
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for(int[] rows : obstacleGrid) {
            for(int i = 0; i < dp.length; i++) {
                if(rows[i] == 1) {
                    dp[i] = 0;
                } else if(i > 0) {
                    dp[i] += dp[i - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }
}