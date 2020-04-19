[Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)  

```Python
class Solution:
    def climbStairs(self, n: int) -> int:
        a, b = 1, 1
        for _ in range(n - 1):
            a, b = a + b, a
        return a


if __name__ == '__main__':
    solution = Solution()
    result = solution.climbStairs(5)
    print(result)
```
