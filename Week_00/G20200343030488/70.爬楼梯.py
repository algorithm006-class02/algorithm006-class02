#
# @lc app=leetcode.cn id=70 lang=python
#
# [70] 爬楼梯
#

# @lc code=start
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n==1:
            return 1

        clib = [1]*n
        clib[1] = 2
        for i in range(2,n):
            clib[i] = clib[i-1]+clib[i-2]

        return clib[n-1]



        
# @lc code=end

