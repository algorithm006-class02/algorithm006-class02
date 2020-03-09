### description
74. 搜索二维矩阵
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
示例 2:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false

### solution
binary search
```python
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m =  len(matrix)
        if m == 0 :
            return False
        n = len(matrix[0])
        hi,lo = m*n-1,0
        while hi>=lo:
            mid = (hi +lo)>>1
            if target == matrix[mid // n][mid%n]:# 整数代表矩阵中元素位置
                return True
            elif target < matrix[mid//n][mid%n]:
                hi = mid - 1
            else:
                lo = mid + 1
        return False

```


cpp
```cpp
class Solution {
  public:
  bool searchMatrix(vector<vector<int>>& matrix, int target) {
    int m = matrix.size();
    if (m == 0) return false;
    int n = matrix[0].size();

    // 二分查找
    int left = 0, right = m * n - 1;
    int pivotIdx, pivotElement;
    while (left <= right) {
      pivotIdx = (left + right) / 2;
      pivotElement = matrix[pivotIdx / n][pivotIdx % n];
      if (target == pivotElement) return true;
      else {
        if (target < pivotElement) right = pivotIdx - 1;
        else left = pivotIdx + 1;
      }
    }
    return false;
  }
};

```