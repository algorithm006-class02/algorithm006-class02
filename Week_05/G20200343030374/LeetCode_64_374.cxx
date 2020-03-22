// https://leetcode-cn.com/problems/minimum-path-sum/
#include <vector>
#include <climits>

using namespace std;

class Solution_1 {
private:
  vector<vector<int>> memo;
public:
    int minPathSum(vector<vector<int>>& grid) {
      if (grid.empty() || grid[0].empty()) return 0;
      int m = grid.size();
      int n = grid[0].size();
      memo.resize(m, vector<int>(n, -1));
      return calc(grid, m, n, 0, 0);
    }
    int calc(vector<vector<int>> &grid, int m, int n, int i, int j) {
      if (i == m || j == n) return INT_MAX;
      if (i == m - 1 && j == n - 1) return grid[i][j];
      if (memo[i][j] != -1) return memo[i][j];
      return memo[i][j] = grid[i][j] + min(calc(grid, m, n, i, j + 1), calc(grid, m, n, i + 1, j));
    }
};

class Solution_2 {
public:
    int minPathSum(vector<vector<int>>& grid) {
      if (grid.empty() || grid[0].empty()) return 0;
      int m = grid.size();
      int n = grid[0].size();
      int dp[m][n];
      dp[m - 1][n - 1] = grid[m - 1][n - 1];
      for (int i = m - 2; i >= 0; --i) {
        dp[i][n - 1] = dp[i + 1][n - 1] + grid[i][n - 1];
      }
      for (int j = n - 2; j >= 0; --j) {
        dp[m - 1][j] = dp[m - 1][j + 1] + grid[m - 1][j];
      }
      for (int i = m - 2; i >= 0; --i) {
        for (int j = n - 2; j >= 0; --j) {
          dp[i][j] = min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
        }
      }
      return dp[0][0];
    }
};