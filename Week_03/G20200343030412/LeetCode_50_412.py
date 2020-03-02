class Solution:
    def myPow(self, x: float, n: int) -> float:
        # 暴力法
        # judge = True
        # if n<0:
        #     n = -n
        #     judge = False
        # if n==0:
        #     return 1
        # final = 1     # 记录当前的乘积值
        # tmp = x       # 记录当前的因子
        # count = 1     # 记录当前的因子是底数的多少倍
        # while n>0:
        #     if n>=count:
        #         final *= tmp  
        #         tmp = tmp*x
        #         n -= count
        #         count +=1  
        #     else:
        #         tmp /= x
        #         count -= 1
        # return final if judge else 1/final

        # 分治
        if n == 0:
            return 1
        if n == 1:
            return x
        if n < 0:
            return 1 / self.myPow(x, -n)
        return self.myPow(x * x, n // 2) if n % 2 == 0 else x * self.myPow(x, n - 1)
