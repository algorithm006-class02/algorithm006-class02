class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsMarking(grid, i, j, n, m);
                }
            }
        }
        return count;
    }

    private void dfsMarking(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i > n - 1 || j > m - 1 || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfsMarking(grid, i - 1, j, n, m);
        dfsMarking(grid, i + 1, j, n, m);
        dfsMarking(grid, i, j - 1, n, m);
        dfsMarking(grid, i, j + 1, n, m);
    }
}
