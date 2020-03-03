### description
69. x 的平方根
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去


### solution
+ 1  binary search

```python
class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:
            return x
        left = 2
        right = x // 2
        while left <= right:
            pivot = left + (right - left) // 2
            num = pivot * pivot
            if num > x:
                right = pivot -1
            elif num < x:
                left = pivot + 1
            else:
                return pivot
            
        return right


```
2. bit && recursion 
```python
class Solution:
    def mySqrt(self, x: int) -> int:
        if x < 2:
            return x

        left = self.mySqrt(x>>2)<<1
        right = left +1
        return left if right*right > x else right
```