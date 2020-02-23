#
# @lc app=leetcode.cn id=283 lang=python
#
# [283] 移动零
#

# @lc code=start
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        j = 0
        for i,num in enumerate(nums):
            if num!=0:
                nums[j] = nums[i]
                
                if i!=j:
                    nums[i]=0
                j+=1
                


        
# @lc code=end

