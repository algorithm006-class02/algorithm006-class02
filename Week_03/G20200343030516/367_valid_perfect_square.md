### description
367. 有效的完全平方数
给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

说明：不要使用任何内置的库函数，如  sqrt。

示例 1：

输入：16
输出：True
示例 2：

输入：14
输出：False

### solution

+ 1 binary search
```python
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        if num < 2:
            return True
        lo = 0
        hi = num //2
        while lo <= hi:
            mid = lo + (hi - lo)//2
            if mid * mid < num:
                lo = mid +1 
            elif mid * mid > num:
                hi = mid -1
            else:
                return True
        return False
```

+2 Newton-Raphson

```python
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        if num < 2:
            return True
        x = num // 2
        while x*x > num:
            x = (x + num//x) // 2
        return x*x == num
```