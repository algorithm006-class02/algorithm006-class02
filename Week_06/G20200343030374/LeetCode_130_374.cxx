// https://leetcode-cn.com/problems/surrounded-regions/
#include <vector>

using namespace std;

class Solution_1 {
public:
    void solve(vector<vector<char>>& board) {
      if (board.empty() || board[0].empty()) return;
      int m = board.size();
      int n = board[0].size();
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          if (i == 0 || j == 0 || i == m - 1 || j == n - 1 && board[i][j] == 'O') {
            dfs(board, i, j, m - 1, n - 1);
          }
        }
      }
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          if (board[i][j] == 'O') board[i][j] = 'X';
          if (board[i][j] == '*') board[i][j] = 'O';
        }
      }
    }
    void dfs(vector<vector<char>> &board, int i, int j, int m, int n) {
      if (i < 0 || j < 0 || i > m || j > n || board[i][j] == '*' || board[i][j] == 'X') return;
      board[i][j] = '*';
      for (int k = 0; k < 4; ++k) dfs(board, i + directions[k], j + directions[k + 1], m, n);
    }
private:
  int directions[5] = {0, 1, 0, -1, 0};
};

// disjoint sets
class Solution {
public:
    void solve(vector<vector<char>>& board) {
      if (board.empty() || board[0].empty()) return;
      int m = board.size();
      int n = board[0].size();
      makeSet(m, n);
      int dummy = m * n;
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          if (board[i][j] == 'O') {
            if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
              unionSet(getIndex(i, j, n), dummy);
            } else if (i > 0 && board[i - 1][j] == 'O') {
              unionSet(getIndex(i, j, n), getIndex(i - 1, j, n));
            } else if (j > 0 && board[i][j - 1] == 'O') {
              unionSet(getIndex(i, j, n), getIndex(i, j - 1, n));
            } else if (i < m - 1 && board[i + 1][j] == 'O') {
              unionSet(getIndex(i, j, n), getIndex(i + 1, j, n));
            } else if (j < n - 1 && board[i][j + 1] == 'O') {
              unionSet(getIndex(i, j, n), getIndex(i, j + 1, n));
            }
          }
        }
      }
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          if (isConnected(getIndex(i, j, n), dummy)) {
            board[i][j] = 'O';
          } else {
            board[i][j] = 'X';
          }
        }
      }
    }
private:
  vector<int> parents;
  void makeSet(int m, int n) {
    int sz = m * n + 1;
    parents.resize(sz);
    for (int i = 0; i < sz; ++i) parents[i] = i;
  }
  int find(int x) {
    return x == parents[x] ? x : find(parents[x]);
  }
  void unionSet(int x, int y) {
    int p1 = find(x);
    int p2 = find(y);
    if (p1 != p2) {
      parents[p2] = p1;
    }
  }
  bool isConnected(int x, int y) {
    return find(x) == find(y);
  }
  int getIndex(int i, int j, int cols) {
    return i * cols + j; 
  }
};