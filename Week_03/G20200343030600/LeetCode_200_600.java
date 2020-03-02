/**
 * 200. 岛屿数量（DFS）
 */

class Solution {
    //全局变量res存储岛屿数量
    int res = 0, row, col;

    public int numIslands(char[][] grid) {
        row = grid.length;
        if (row == 0) return 0;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void helper(char[][] grid, int i, int j) {
        if (i >= row || i < 0 || j >= col || j < 0) return;
        if (grid[i][j] != '1') return;
        grid[i][j] = 0;
        helper(grid, i - 1, j);
        helper(grid, i + 1, j);
        helper(grid, i, j - 1);
        helper(grid, i, j + 1);
    }
}
