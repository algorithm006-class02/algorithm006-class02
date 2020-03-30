class Solution:
    def hammingWeight(self, n: int) -> int:
        # return self.hammingWeight_v1(n)
        return self.hammingWeight_v2(n)


    def hammingWeight_v1(self, n: int) -> int:
        # 十进制转二进制
        res = 0
        while n:
            if n % 2 == 1:
                res += 1
            n //= 2
        return res

    def hammingWeight_v2(self, n: int) -> int:
        # 位运算, 清零最低位的1 x = x & (x - 1)
        res = 0
        while n:
            res += 1
            n = n & (n - 1)
        return res
