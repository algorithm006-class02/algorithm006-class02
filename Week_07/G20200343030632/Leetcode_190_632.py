class Solution:
    def reverseBits(self, n: int) -> int:
        # 从低位开始按位取出, 填入32位或64位即可
        res = 0
        for i in range(31, -1, -1):
            res += (n & 1) << i
            n = n >> 1
        return res