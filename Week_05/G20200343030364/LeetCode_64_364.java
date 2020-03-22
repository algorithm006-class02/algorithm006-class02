/**
 * Created by HuGuodong on 3/9/20.
 */
public class LeetCode_64_364 {

  public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] state = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          state[i][j] = grid[i][j];
          continue;
        }
        else if (i == 0) {
          state[i][j] = state[i][j - 1] + grid[i][j];
          continue;
        }
        else if (j == 0) {
          state[i][j] = state[i - 1][j] + grid[i][j];
          continue;
        }
        else {
          state[i][j] = Math.min(state[i - 1][j], state[i][j - 1]) + grid[i][j];
        }
      }
    }
    return state[m - 1][n - 1];
  }
}
