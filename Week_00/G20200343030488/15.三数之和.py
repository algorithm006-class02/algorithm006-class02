#
# @lc app=leetcode.cn id=15 lang=python
#
# [15] 三数之和
#

# @lc code=start
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res = []
        for k in range(len(nums)-2):
            i,j = k+1,len(nums)-1
            if nums[k]>0:continue
            if k>0 and nums[k]==nums[k-1]:continue
            while i<j:
                s = nums[k]+nums[i]+nums[j]
                if s>0:
                    j-=1
                    while i<j and nums[j+1]==nums[j]:j-=1
                elif s<0:
                    i+=1
                    while i<j and nums[i-1]==nums[i]:i+=1
                else:
                    res.append([nums[i],nums[j],nums[k]])
                    i+=1
                    j-=1
                    while i<j and nums[j+1]==nums[j]:j-=1
                    while i<j and nums[i-1]==nums[i]:i+=1
        return res


        # @lc code=end

