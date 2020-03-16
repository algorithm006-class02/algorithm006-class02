public class LeetCode_64_422 {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return minPathSumHelper(grid, 0, 0, memo);
    }

    public int minPathSumHelper(int[][] grid, int row, int col, int[][] memo) {
        if(row == grid.length-1 && col == grid[0].length-1) {
            return grid[row][col];
        }
        if(memo[row][col] != 0) {
            return memo[row][col];
        }

        int rowInc = Integer.MAX_VALUE, colInc = Integer.MAX_VALUE;
        if(row < grid.length-1) {
            rowInc = minPathSumHelper(grid, row+1, col, memo);
        }
        if(col < grid[0].length-1) {
            colInc = minPathSumHelper(grid, row, col+1, memo);
        }
        memo[row][col] = Math.min(rowInc, colInc) + grid[row][col];
        return memo[row][col];
    }
}
