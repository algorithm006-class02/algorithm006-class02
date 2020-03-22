class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];
        for(int i = row - 1 ; i >= 0 ; i --) {
            for(int j = col - 1 ; j >= 0 ; j --) {
                if(i == row - 1 && j == col - 1) {
                    dp[j] = grid[i][j];
                } else if(i == row - 1 && j != col - 1) {
                    dp[j] = dp[j + 1] + grid[i][j];
                } else if(i != row - 1 && j == col -1) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + grid[i][j];
                }
            }
        }

        return dp[0];
    }
}