#
# @lc app=leetcode.cn id=11 lang=python
#
# [11] 盛最多水的容器
#

# @lc code=start
class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """

        i = 0
        j = len(height)-1
        res = 0

        while(i<j):
            
            if height[i]<height[j]:
                res = max(res,(j-i)*min(height[i],height[j]))
                i+=1
            else:
                res = max(res,(j-i)*min(height[i],height[j]))
                j-=1
        return res

        
# @lc code=end

# test = Solution()
# height = [1,8,6,2,5,4,8,3,7]

# print(test.maxArea(height))