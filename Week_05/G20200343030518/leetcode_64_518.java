class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] sum = new int[row][col];
        sum[0][0] = grid[0][0];
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++){
                if (i == 0 && j > 0){
                    sum[i][j] = sum[i][j - 1] + grid[i][j];
                }
                else if (j == 0 && i > 0){
                    sum[i][j] =  sum[i - 1][j] + grid[i][j];
                } else if (i > 0 && j > 0){ // use if else if else if structure
                    sum[i][j] = Math.min(sum[i][j - 1], sum[i - 1][j]) + grid[i][j];
                }
            }
        }
        return sum[row - 1][col - 1]; // not sum[row][col]
    }
}