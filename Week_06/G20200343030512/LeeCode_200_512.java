package Week_06.G20200343030512;

 class Solution {
    public int numIslands(char[][] grid) {
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') { dfs(grid, i, j); c++; }
            }
        }
        return c;
    }

    private void dfs(char[][] grid, int r, int c) {
        grid[r][c] = 0;
        if (r - 1 >= 0 && grid[r - 1][c] == '1') dfs(grid, r - 1, c);
        if (r + 1 < grid.length && grid[r + 1][c] == '1') dfs(grid, r + 1, c);
        if (c - 1 >= 0 && grid[r][c - 1] == '1') dfs(grid, r, c - 1);
        if (c + 1 < grid[r].length && grid[r][c + 1] == '1') dfs(grid, r, c + 1);
    }

}