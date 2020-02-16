#
# @lc app=leetcode.cn id=26 lang=python
#
# [26] 删除排序数组中的重复项
#

# @lc code=start
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i = 0
        length = len(nums)
        for j in range(1,length):
            if nums[i]!=nums[j]:
                i+=1
                nums[i] = nums[j]
        return i+1

            


        
# @lc code=end

