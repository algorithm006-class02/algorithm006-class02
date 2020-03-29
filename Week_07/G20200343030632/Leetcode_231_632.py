class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        # 判断是否2的n次幂转为判断该数字的2进制是否只有一个1
        return n != 0 and (n & (n - 1) == 0)