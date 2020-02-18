#
# @lc app=leetcode.cn id=66 lang=python
#
# [66] 加一
#

# @lc code=start
class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        n = len(digits)
        for i in range(n-1,-1,-1):
            digits[i]+=1
            digits[i] = digits[i] %10
            if digits[i]!=0:
                return digits
        digits = [0]*(n+1)
        digits[0] = 1
        return digits


        
# @lc code=end

