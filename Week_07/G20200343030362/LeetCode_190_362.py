class Solution:
def reverseBits(self, n: int) -> int:
    ret = 0
    for i in range(32):
        ret = ret | (n & 1) << (31 - i)
        n = n >> 1
    return ret
