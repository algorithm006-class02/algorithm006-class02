class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            n = -n
            x = 1 / x
        
        res = 1

        while n:
            if n & 1:
                res *= x
            x *= x
            # 右移一位
            n >>= 1 
        return res