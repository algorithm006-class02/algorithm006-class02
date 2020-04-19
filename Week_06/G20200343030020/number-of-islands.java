//岛屿数量2
class Solution {
    private int n, m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0)
            return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    DfsMark(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void DfsMark(char grid[][], int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        DfsMark(grid, i + 1, j);
        DfsMark(grid, i - 1, j);
        DfsMark(grid, i, j + 1);
        DfsMark(grid, i, j - 1); // 进行所谓的四连通的遍历
    }
}
