# =====================================
# No.231  2的幂
# 解题思路：暴力破解法，不断除以2，直到余数
# =====================================

class Solution(object):
    def isPowerOfTwo(self, n):
        if(n==1):
            return True
        elif(n<=0):
            return False
        else :
            while(n%2==0):
                if(n==2):
                    return True
                else:
                    n = n/2
            return False


if __name__ == '__main__':
    sol = Solution()
    print(sol.isPowerOfTwo(2))
    print(sol.isPowerOfTwo(16))
    print(sol.isPowerOfTwo(218))
