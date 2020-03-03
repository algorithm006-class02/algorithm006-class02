//https://leetcode-cn.com/problems/number-of-islands/

#include <vector>
#include <queue>

using namespace std;

class Solution_1
{
public:
  int numIslands(vector<vector<char>> &grid)
  {
    if (grid.empty())
      return 0;
    int rows = grid.size();
    int cols = grid.front().size();
    int counts = 0;
    for (int i = 0; i < rows; ++i)
    {
      for (int j = 0; j < cols; ++j)
      {
        if (grid[i][j] == '1')
        {
          ++counts;
          sink(grid, i, j);
        }
      }
    }
    return counts;
  }
  void sink(vector<vector<char>> &grid, int i, int j)
  {
    int rows = grid.size();
    int cols = grid.front().back();

    grid[i][j] = '0';
    if (i + 1 < rows && grid[i + 1][j] == '1')
    {
      sink(grid, i + 1, j);
    }
    if (i - 1 >= 0 && grid[i - 1][j] == '1')
    {
      sink(grid, i - 1, j);
    }
    if (j + 1 < cols && grid[i][j + 1] == '1')
    {
      sink(grid, i, j + 1);
    }
    if (j - 1 >= 0 && grid[i][j - 1] == '1')
    {
      sink(grid, i, j - 1);
    }
  }
};

class Solution_2
{
private:
  int ds[5] = {0, 1, 0, -1, 0};

public:
  int numIslands(vector<vector<char>> &grid)
  {
    if (grid.empty())
      return 0;
    int rows = grid.size();
    int cols = grid.front().size();
    int counts = 0;
    for (int i = 0; i < rows; ++i)
    {
      for (int j = 0; j < cols; ++j)
      {
        if (grid[i][j] == '1')
        {
          ++counts;
          sink(grid, i, j, rows, cols);
        }
      }
    }
  }
  void sink(vector<vector<char>> &grid, int i, int j, int rows, int cols)
  {
    grid[i][j] = '0';
    // terminator
    if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0')
      return;
    for (int k = 0; k < 4; ++k)
    {
      int r = i + ds[k];
      int c = j + ds[k + 1];
      sink(grid, r, c, rows, cols);
    }
  }
};

// BFS
class Solution_3
{
public:
  int numIslands(vector<vector<char>> &grid)
  {
    if (grid.empty())
      return 0;
    int rows = grid.size();
    int cols = grid.back().size();
    int ds[5] = {0, 1, 0, -1, 0};
    int counts = 0;
    queue<pair<int, int>> q;
    for (int i = 0; i < rows; ++i)
    {
      for (int j = 0; j < cols; ++j)
      {
        if (grid[i][j] == '1')
        {
          ++counts;
          q.push({i, j});
          grid[i][j] = '0';
          while (!q.empty())
          {
            pair<int, int> coordinates = q.front();
            q.pop();
            int row = coordinates.first;
            int col = coordinates.second;
            for (int k = 0; k < 4; ++k)
            {
              int r = row + ds[k];
              int c = col + ds[k + 1];
              if (grid[r][c] == '1')
              {
                q.push({r, c});
                grid[r][c] = '0';
              }
            }
          }
        }
      }
    }
    return counts;
  }
};