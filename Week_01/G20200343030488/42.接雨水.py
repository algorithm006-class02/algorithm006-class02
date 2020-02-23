#
# @lc app=leetcode.cn id=42 lang=python
#
# [42] 接雨水
#

# @lc code=start
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        length = len(height)
        left, right = 0, length-1
        total = 0
        max_left, max_right = 0, 0
        while(left<right):
            if height[left]<height[right]:
                if height[left]>max_left:
                    max_left = height[left]
                else:
                    total+=(max_left - height[left])
                left+=1
            else:
                if height[right]>max_right:
                    max_right = height[right]
                else:
                    total+=(max_right - height[right])
                right-=1
        return total

# @lc code=end

