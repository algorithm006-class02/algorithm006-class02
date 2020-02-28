/**
 * Created by HuGuodong on 2/28/20.
 */
public class LeetCode_200_364 {

  class Solution {

    public int numIslands(char[][] grid) {

      int m = grid.length;
      if (m == 0) return 0;
      int n = grid[0].length;
      if (m == 0 && n == 0) return 0;
      int count = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == '1') {
            dfs(grid, i, j);
            count++;
          }
        }
      }
      return count;
    }

    private void dfs(char[][] grid, int i, int j) {
      if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
      grid[i][j] = '0';
      dfs(grid, i - 1, j);
      dfs(grid, i + 1, j);
      dfs(grid, i, j - 1);
      dfs(grid, i, j + 1);
    }
  }
}
