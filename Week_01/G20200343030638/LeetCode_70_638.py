class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        f1, f2, f3 = 1, 2, 3
        for i in range(n - 2):
            f3 = f1 + f2
            f1 = f2
            f2 = f3
        return f3