class LeetCode_64_024 {

    public static void main(String[] args) {
        new LeetCode_64_024().minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }

        return grid[grid.length - 1][grid[0].length];
    }

}
