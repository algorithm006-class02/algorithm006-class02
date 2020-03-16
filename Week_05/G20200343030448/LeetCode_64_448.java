package G20200343030448;

public class LeetCode_64_448 {
    public int minPathSum(int[][] grid) {
        //二位数组
/*      int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) { //处理最右下角一个块
                    dp[i][j] = grid[i][j];
                } else if (i == m - 1 && j != n - 1) { //处理最下一行
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (i != m - 1 && j == n - 1) { //处理最右一列
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];*/

        //一维数组
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) { //处理最右下角一个块
                    dp[j] = grid[i][j];
                } else if (i == m - 1 && j != n - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (i != m - 1 && j == n - 1) {
                    dp[j] += grid[i][j];
                } else {
                    dp[j] = grid[i][j] + (dp[j + 1] > dp[j] ? dp[j] : dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}
