// https://leetcode-cn.com/problems/search-a-2d-matrix/

#include <vector>
#include <algorithm>

using namespace std;

class Solution_1
{
public:
  bool searchMatrix(vector<vector<int>> &matrix, int target)
  {
    for (vector<int> row : matrix)
    {
      if (binary_search(row.begin(), row.end(), target))
        return true;
    }
    return false;
  }
};

class Solution_2
{
public:
  // O(M*logN)
  bool searchMatrix(vector<vector<int>> &matrix, int target)
  {
    for (const vector<int> &sub : matrix)
    {
      if (binary_search(sub, target))
        return true;
    }
    return false;
  }
  bool binary_search(const vector<int> &v, int target)
  {
    int size = v.size();
    int left = 0;
    int right = size - 1;
    while (left <= right)
    {
      int mid = ((right - left) >> 1) + left;
      if (v[mid] == target)
        return true;
      if (v[mid] < target)
      {
        left = mid + 1;
      }
      else
      {
        right = mid - 1;
      }
    }
    return false;
  }
};

class Solution_3
{
public:
  // O(logN)
  bool searchMatrix(vector<vector<int>> &matrix, int target)
  {
    int m = matrix.size();
    if (!m)
      return false;
    int n = matrix.back().size();
    int left = 0;
    int right = m * n - 1;
    while (left <= right)
    {
      int mid = ((right - left) >> 1) + left;
      int row = mid / n;
      int col = mid % n;
      if (matrix[row][col] == target)
        return true;
      if (matrix[row][col] < target)
      {
        left = mid + 1;
      }
      else
      {
        right = mid - 1;
      }
    }
    return false;
  }
};