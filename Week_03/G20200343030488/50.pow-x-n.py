#
# @lc app=leetcode.cn id=50 lang=python
#
# [50] Pow(x, n)
#

# @lc code=start
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n==0:
            return 1
        if n==-1:
            return 1/x
        half = self.myPow(x,n//2)
        if n%2==0:
            return half*half
        else:
            return half*half*x


# @lc code=end

