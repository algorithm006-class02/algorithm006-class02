class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            x, n = 1 / x, -1 * n
        res = self.helper(x, n)            
        return res
    
    def helper(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        res = self.helper(x, n // 2)
        if n % 2 == 0:
            return res * res
        else:
            return res * res * x