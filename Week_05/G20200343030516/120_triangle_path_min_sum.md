## description
120. 三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

### solution
cur:dp[i] = prev:  min( dp[i] dp[i+1] ) + dp[i]

```python
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)
        if n< 2:
            return min(triangle[-1])
        dp =triangle[-1]
        for i in range(n-2,-1,-1):
            for j in range(i+1):
                dp[j] = min(dp[j],dp[j+1]) + triangle[i][j]
        return dp[0]
```