# -*- coding: utf-8 -*-
"""
50. Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数
此题不能使用库函数！

"""

# 分治思想+递归 = 快速幂算法
class Solution:
    """
    将大问题pow(x, n)划分为小问题pow(x, n/2)
    时间复杂度：O(logN)
    """
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        
        if n < 0:
            return 1.0 / self.myPow(x, -n)
        
        if n % 2 == 0:
            # even
            return self.myPow(x*x, n//2)
        else:
            # odd
            return x * self.myPow(x, n-1)
        


# 暴力循环法(不建议，会超出时间限制)
class Solution2:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0

        N = n
        if n < 0:
            x = 1 / x
            N = -N
        
        ans = 1.0
        for _ in range(N):
            ans = ans * x
        return  ans

# Golang 版本实现
"""
func help(x float64, n int) float64 {
	if n == 1 {
		return x
	} else if n&1 == 0 {
		return help(x*x, n/2)
	} else {
		return x * help(x, n-1)
	}
}

func myPow(x float64, n int) float64 {
	if n < 0 {
		return help(1.0/x, -n)
	} else if n == 0 {
		return 1
	} else {
		return help(x, n)
	}
}

"""