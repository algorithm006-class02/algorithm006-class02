class Solution:
    def reverseBits(self, n: int) -> int:
        #思路1:进行移位运算,左边的位需要放到右边的位置
        res=0
        for i in range(32):
            res|=((n>>i & 1)<<31-i)
        return res
        
        """
        #思路2：每次取出最低位存储到结果中
        res=0
        for i in range(32):
            res<<=1
            res+=n&1 
            n>>=1 
        return res 
        """