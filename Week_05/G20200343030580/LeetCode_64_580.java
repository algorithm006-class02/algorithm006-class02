class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = m - 2; i > -1; i--) {
            grid[n - 1][i] = grid[n - 1][i] + grid[n - 1][i + 1];
        }
        for (int i = n - 2; i > -1; i--) {
            grid[i][m - 1] = grid[i][m - 1] + grid[i + 1][m - 1];
        }
        for (int i = n - 2; i > -1; i--) {
            for (int j = m - 2; j > -1; j--) {
                grid[i][j] = Math.min(grid[i + 1][j], grid[i][j + 1]) + grid[i][j];
            }
        }
        return grid[0][0];
    }

}
